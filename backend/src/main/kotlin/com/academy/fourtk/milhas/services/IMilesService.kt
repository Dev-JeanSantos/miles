package com.academy.fourtk.milhas.services

import com.academy.fourtk.milhas.dtos.MilesResponse
import com.academy.fourtk.milhas.dtos.MilesRequest
import com.academy.fourtk.milhas.dtos.MultiplierResponse
import com.academy.fourtk.milhas.dtos.multiplierRequest

interface IMilesService {
    fun calculate(milesRequest: MilesRequest): MilesResponse
    fun calculateMultiplier(request: multiplierRequest): MultiplierResponse

}
