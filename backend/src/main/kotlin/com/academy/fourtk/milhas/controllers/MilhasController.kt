package com.academy.fourtk.milhas.controllers

import com.academy.fourtk.milhas.dtos.*
import com.academy.fourtk.milhas.dtos.requesties.MilesRequest
import com.academy.fourtk.milhas.dtos.requesties.multiplierRequest
import com.academy.fourtk.milhas.dtos.responses.CardMileAccumulationResponse
import com.academy.fourtk.milhas.dtos.responses.MilesResponse
import com.academy.fourtk.milhas.dtos.responses.MultiplierResponse
import com.academy.fourtk.milhas.enums.ErrorType
import com.academy.fourtk.milhas.exceptions.BadRequestErrorResponse
import com.academy.fourtk.milhas.services.IMilesService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/miles/")
class MilesController(val IMilesService: IMilesService) {

    @PostMapping("calculate_thousand")
    fun calculateThousand(@RequestBody milesRequest: MilesRequest): MilesResponse {

        return try {
            return IMilesService.calculate(milesRequest)
        } catch (e: Exception) {
            MilesResponse.of(
                BadRequestErrorResponse(
                    ErrorType.INVALID_PAYLOAD,
                    e.message
                )
            )
        }
    }

    @PostMapping("calculate_multiplier")
    fun calculateMultiplier(@RequestBody request: multiplierRequest): MultiplierResponse {

        return try {
            return IMilesService.calculateMultiplier(request)
        } catch (e: Exception) {
            MultiplierResponse.of(
                BadRequestErrorResponse(
                    ErrorType.INVALID_PAYLOAD,
                    e.message
                )
            )
        }
    }

    @PostMapping("calculate_cardmileaccumulation")
    fun calculateCardMileAccumulation(@RequestBody data: CardMileAccumulationRequest): CardMileAccumulationResponse {
            return IMilesService.calculateCardMileAccumulation(data)
    }

}
