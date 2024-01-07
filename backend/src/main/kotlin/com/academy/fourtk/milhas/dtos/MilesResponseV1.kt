package com.academy.fourtk.milhas.dtos

import com.academy.fourtk.milhas.enums.Program
import com.fasterxml.jackson.annotation.JsonProperty

data class MilesResponseV1(
    @JsonProperty("value_of_million")
    val valueOfMillion: Double? = null,
    val program: Program? = null
)
