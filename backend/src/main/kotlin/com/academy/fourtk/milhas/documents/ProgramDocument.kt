package com.academy.fourtk.milhas.documents

import com.academy.fourtk.milhas.enums.ProgramType
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document
data class ProgramDocument(
    val startDate: LocalDateTime,
    val endDate: LocalDateTime? = null,
    val name: String,
    val memberNumber: String,
    val points: Int? =  null,
    val officialValueOfMillion: Int,
    val unofficialValueOfMillion: Int,
    val programType: ProgramType,
    val version: Int? = null
)
