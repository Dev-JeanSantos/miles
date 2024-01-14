package com.academy.fourtk.milhas.services

import com.academy.fourtk.milhas.dtos.CardMileAccumulationRequest
import com.academy.fourtk.milhas.dtos.requesties.MilesRequest
import com.academy.fourtk.milhas.dtos.requesties.PayloadMilesRequest
import com.academy.fourtk.milhas.dtos.requesties.multiplierRequest
import com.academy.fourtk.milhas.dtos.responses.CardMileAccumulationResponse
import com.academy.fourtk.milhas.dtos.responses.MilesResponse
import com.academy.fourtk.milhas.dtos.responses.MultiplierResponse
import com.academy.fourtk.milhas.dtos.responses.PayloadMilesResponse

interface IMilesService {
    fun calculate(milesRequest: MilesRequest): MilesResponse
    fun calculateMultiplier(request: multiplierRequest): MultiplierResponse
    fun calculateCardMileAccumulation(data: CardMileAccumulationRequest): CardMileAccumulationResponse
    fun registerMiles(data: PayloadMilesRequest): PayloadMilesResponse
}
