package com.academy.fourtk.milhas.dtos

import com.academy.fourtk.milhas.enums.Program
import com.fasterxml.jackson.annotation.JsonProperty

data class MilesRequest(
    val program: Program,
    @JsonProperty("number_points")
    val numberPoints: Int,
    @JsonProperty("total_purchases")
    val totalPurchases: Double
)
