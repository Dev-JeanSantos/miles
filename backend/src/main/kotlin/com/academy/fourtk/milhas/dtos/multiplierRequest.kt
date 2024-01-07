package com.academy.fourtk.milhas.dtos

import com.fasterxml.jackson.annotation.JsonProperty

data class multiplierRequest(
    @JsonProperty("total_purchases")
    val totalPurchases: Double,
    @JsonProperty("total_miles")
    val totalMiles: Int
)
