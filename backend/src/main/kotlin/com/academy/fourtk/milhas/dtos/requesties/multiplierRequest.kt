package com.academy.fourtk.milhas.dtos.requesties

import com.fasterxml.jackson.annotation.JsonProperty

data class multiplierRequest(
    @JsonProperty("total_purchases")
    val totalPurchases: Double,
    @JsonProperty("total_miles")
    val totalMiles: Int
)
