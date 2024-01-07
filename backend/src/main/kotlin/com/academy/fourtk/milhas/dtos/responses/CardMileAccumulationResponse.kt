package com.academy.fourtk.milhas.dtos.responses

import com.fasterxml.jackson.annotation.JsonProperty

data class CardMileAccumulationResponse(
    @JsonProperty("score_received_by_month")
    val scoreReceivedByMonth: Int,
    @JsonProperty("score_received_by_year")
    val scoreReceivedByYear: Int
)