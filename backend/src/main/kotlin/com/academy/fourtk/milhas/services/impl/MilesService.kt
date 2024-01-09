package com.academy.fourtk.milhas.services.impl

import com.academy.fourtk.milhas.builders.milesBuilder
import com.academy.fourtk.milhas.builders.milesResponseBuilder
import com.academy.fourtk.milhas.dtos.CardMileAccumulationRequest
import com.academy.fourtk.milhas.dtos.entities.Ok
import com.academy.fourtk.milhas.dtos.requesties.MilesRequest
import com.academy.fourtk.milhas.dtos.requesties.PayloadMilesRequest
import com.academy.fourtk.milhas.dtos.requesties.multiplierRequest
import com.academy.fourtk.milhas.dtos.responses.CardMileAccumulationResponse
import com.academy.fourtk.milhas.dtos.responses.MilesResponse
import com.academy.fourtk.milhas.dtos.responses.MultiplierResponse
import com.academy.fourtk.milhas.dtos.responses.PayloadMilesResponse
import com.academy.fourtk.milhas.repositories.MilesRepository
import com.academy.fourtk.milhas.repositories.ProgramRepository
import com.academy.fourtk.milhas.services.IMilesService
import org.springframework.stereotype.Service
import java.math.RoundingMode

@Service
class MilesService(
    private val programRepository: ProgramRepository,
    private val repository: MilesRepository
): IMilesService {
    override fun calculate(milesRequest: MilesRequest): MilesResponse {
        return MilesResponse(valueOfMillion = calcularMilhas(milesRequest).toBigDecimal().setScale(2, RoundingMode.UP), program = milesRequest.program, ok = Ok())
    }

    override fun calculateMultiplier(request: multiplierRequest): MultiplierResponse {
        return  MultiplierResponse(multiplier = calcularMultiplos(request), ok = Ok())
    }

    override fun calculateCardMileAccumulation(data: CardMileAccumulationRequest): CardMileAccumulationResponse {
       return CardMileAccumulationResponse(
           scoreReceivedByMonth = ((data.cardScore * data.invoiceAmount) / DOLAR).toInt(),
           scoreReceivedByYear = (((data.cardScore * data.invoiceAmount) / DOLAR) * YEARL).toInt()
       )
    }

    override fun registerMiles(data: PayloadMilesRequest): PayloadMilesResponse {
        val miles = repository.save(milesBuilder(data, programRepository))
        return milesResponseBuilder(miles)
    }

    private fun calcularMultiplos(request: multiplierRequest): Double {
        return (request.totalMiles / request.totalPurchases)
    }

    private fun calcularMilhas(milesRequest: MilesRequest): Double {
        return (milesRequest.totalPurchases / milesRequest.numberPoints) * 1000
    }


    companion object{
        const val YEARL: Int = 12
        const val DOLAR: Double = 5.0
    }
}