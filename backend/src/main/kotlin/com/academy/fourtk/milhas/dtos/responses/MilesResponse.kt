package com.academy.fourtk.milhas.dtos.responses

import com.academy.fourtk.milhas.enums.Program
import com.academy.fourtk.milhas.enums.StatusBuyMiles
import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal

data class MilesResponse(
    @JsonProperty("value_of_million")
    val valueOfMillion: BigDecimal? = null,
    @JsonProperty("total_points")
    val totalPoints : Int? = null,
    val program: Program? = null,
    val statusBuyMiles: StatusBuyMiles? = null
)