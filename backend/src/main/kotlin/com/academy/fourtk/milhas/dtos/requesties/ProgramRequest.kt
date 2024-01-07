package com.academy.fourtk.milhas.dtos.requesties

import com.academy.fourtk.milhas.enums.ProgramType
import com.fasterxml.jackson.annotation.JsonProperty

data class ProgramRequest (

    val name: String,
    @JsonProperty("member_number")
    val memberNumber: String,
    @JsonProperty("official_value_of_million")
    val officialValueOfMillion: Int,
    @JsonProperty("unofficial_value_of_million")
    val unofficialValueOfMillion: Int,
    @JsonProperty("program_type")
    val programType: ProgramType
)