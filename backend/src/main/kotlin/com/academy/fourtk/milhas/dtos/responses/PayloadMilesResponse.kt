package com.academy.fourtk.milhas.dtos.responses

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal
import java.time.LocalDateTime

data class PayloadMilesResponse (
    @JsonProperty("origin_miles")
    val originMiles: String,
    @JsonProperty("quantity_miles")
    val quantityMiles: Int,
    @JsonProperty("amount_paid")
    val amountPaid: BigDecimal,
    @JsonProperty("thousand_cost")
    val thousandCost: BigDecimal,
    @JsonProperty("start_date")
    val startDate: String,
)