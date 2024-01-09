package com.academy.fourtk.milhas.dtos.requesties

import com.academy.fourtk.milhas.enums.OriginMiles
import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal

data class PayloadMilesRequest(
    @JsonProperty("program_name")
    val programName: String,
    @JsonProperty("origin_miles")
    val originMiles: OriginMiles,
    @JsonProperty("description")
    val description: String,
    @JsonProperty("quantity_miles")
    val quantityMiles: Int,
    @JsonProperty("amount_paid")
    val amountPaid: BigDecimal,
    @JsonProperty("thousand_cost")
    val thousandCost: BigDecimal
)
