package com.academy.fourtk.milhas.dtos

import com.fasterxml.jackson.annotation.JsonProperty

data class DataCardMileAccumulation(
    @JsonProperty("invoice_amount")
    val invoiceAmount: Double,
    @JsonProperty("card_score")
    val cardScore:Double
)
