package com.academy.fourtk.milhas.entitites

import com.academy.fourtk.milhas.enums.ProgramType
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Program(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val startDate: LocalDateTime,
    val endDate: LocalDateTime? = null,
    val name: String,
    val memberNumber: String,
    val points: Int? =  null,
    val officialValueOfMillion: Double,
    val unofficialValueOfMillion: Double,
    @Enumerated(EnumType.STRING)
    val programType: ProgramType
)