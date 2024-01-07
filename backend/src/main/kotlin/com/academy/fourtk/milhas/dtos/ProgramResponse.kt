package com.academy.fourtk.milhas.dtos

import com.academy.fourtk.milhas.enums.ProgramType
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class ProgramResponse (
    val name: String,
    @JsonProperty("member_number")
    val memberNumber: String,
    val points: Int? = null,
    @JsonProperty("official_value_of_million")
    val officialValueOfMillion: Int,
    @JsonProperty("unofficial_value_of_million")
    val unofficialValueOfMillion: Int,
    @JsonProperty("program_type")
    val programType: ProgramType,
    @JsonProperty("start_date")
    val startDate: LocalDateTime? = null,
    @JsonProperty("end_date")
    val endDate: LocalDateTime? = null
)