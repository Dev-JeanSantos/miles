package com.academy.fourtk.milhas.services.impl

import com.academy.fourtk.milhas.dtos.MilesResponse
import com.academy.fourtk.milhas.dtos.MilesRequest
import com.academy.fourtk.milhas.dtos.MultiplierResponse
import com.academy.fourtk.milhas.dtos.entities.Ok
import com.academy.fourtk.milhas.dtos.multiplierRequest
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

    private fun calcularMultiplos(request: multiplierRequest): Double {
        return (request.totalMiles / request.totalPurchases)
    }

    private fun calcularMilhas(milesRequest: MilesRequest): Double {
        return ((milesRequest.totalPurchases / milesRequest.numberPoints) * 1000)
    }

    private fun Double.format(scale: Int) = "%.${scale}f".format(this)
}