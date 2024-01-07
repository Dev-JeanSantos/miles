package com.academy.fourtk.milhas.services.impl

import com.academy.fourtk.milhas.dtos.*
import com.academy.fourtk.milhas.dtos.entities.Ok
import com.academy.fourtk.milhas.services.IMilesService
import org.springframework.stereotype.Service

@Service
class MilesService: IMilesService {
    override fun calculate(milesRequest: MilesRequest): MilesResponse {
        return MilesResponse(valueOfMillion = calcularMilhas(milesRequest), program = milesRequest.program, ok = Ok())
    }

    override fun calculateMultiplier(request: multiplierRequest): MultiplierResponse {
        return  MultiplierResponse(multiplier = calcularMultiplos(request), ok = Ok())
    }

    override fun calculateCardMileAccumulation(data: DataCardMileAccumulation): CardMileAccumulationResponse {
       return CardMileAccumulationResponse(
           scoreReceivedByMonth = ((data.cardScore * data.invoiceAmount) / DOLAR).toInt(),
           scoreReceivedByYear = (((data.cardScore * data.invoiceAmount) / DOLAR) * YEARL).toInt()
       )
    }

    private fun calcularMultiplos(request: multiplierRequest): Double {
        return (request.totalMiles / request.totalPurchases)
    }

    private fun calcularMilhas(milesRequest: MilesRequest): Double {
        return ((milesRequest.totalPurchases / milesRequest.numberPoints) * 1000)
    }


    companion object{
        const val YEARL: Int = 12
        const val DOLAR: Double = 5.0
    }
}