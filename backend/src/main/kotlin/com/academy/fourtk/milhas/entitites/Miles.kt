package com.academy.fourtk.milhas.entitites

import com.academy.fourtk.milhas.enums.OriginMiles
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
data class Miles(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val originMiles: OriginMiles,
    val description: String,
    val quantityMiles: Int,
    val amountPaid: BigDecimal,
    val thousandCost: BigDecimal,
    val startDate: LocalDateTime,
    val updateDate: LocalDateTime? = null,

    @ManyToOne
    @JoinColumn(name = "program_id")
    val program: Program,
)