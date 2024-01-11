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
import com.academy.fourtk.milhas.exceptions.NotFoundException
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
        val bonusPoints = (milesRequest.numberPoints * milesRequest.bonusPercentage) / 100
        val totalPoints = (milesRequest.numberPoints + bonusPoints).toInt()

        val valueOfMiles = calcularMilhas(milesRequest, pointsTotal = totalPoints).toBigDecimal().setScale(2, RoundingMode.UP)

        val possibleProgram = programRepository.findByName(milesRequest.program.name)
        val program = possibleProgram.orElseThrow { NotFoundException("Program ${milesRequest.program} not found") }

        var message: String = ""

        when(program.name){
            "SMILES" -> if (valueOfMiles <= program.unofficialValueOfMillion.toBigDecimal()){
                message = "ENJOY IT, IT’S WORTH IT"
            } else{
                println("nao compensa")
            }

            else -> {}
        }

        return MilesResponse(
            valueOfMillion = valueOfMiles  ,
            totalPoints = totalPoints ,
            program = milesRequest.program,
            message = message)
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

    private fun calcularMilhas(milesRequest: MilesRequest, pointsTotal: Int): Double {
        return (milesRequest.totalPurchases / pointsTotal) * 1000
    }


    companion object{
        const val YEARL: Int = 12
        const val DOLAR: Double = 5.0
    }
}