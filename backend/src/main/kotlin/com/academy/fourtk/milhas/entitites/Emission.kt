package com.academy.fourtk.milhas.entitites

import com.academy.fourtk.milhas.enums.StatusFlightEmissions
import com.fasterxml.jackson.annotation.JsonProperty

data class Emission(
    @JsonProperty("total_points")
    val totalPoints: Double,
    @JsonProperty("total_conversion_cost")
    val totalConversionCost: Double,
    @JsonProperty("total_cash_value")
    val totalCashValue: Double,
    @JsonProperty("passenger_numbers")
    val passengerNumbers: Int,
    @JsonProperty("status_flight_emissions")
    val statusFlightEmissions: StatusFlightEmissions
)
