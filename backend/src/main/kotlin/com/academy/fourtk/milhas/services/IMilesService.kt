package com.academy.fourtk.milhas.services

import com.academy.fourtk.milhas.dtos.*

interface IMilesService {
    fun calculate(milesRequest: MilesRequest): MilesResponse
    fun calculateMultiplier(request: multiplierRequest): MultiplierResponse
    fun calculateCardMileAccumulation(data: DataCardMileAccumulation): CardMileAccumulationResponse

}
