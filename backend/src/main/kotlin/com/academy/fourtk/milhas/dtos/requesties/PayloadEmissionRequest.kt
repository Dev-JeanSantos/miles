package com.academy.fourtk.milhas.dtos.requesties

import com.fasterxml.jackson.annotation.JsonProperty

data class PayloadEmissionRequest(
    @JsonProperty("total_points_per_section")
    val totalPointsPerSection: Double,
    @JsonProperty("total_points_round_trip")
    val totalPointsRoundTrip: Double,
    @JsonProperty("costs_per_segment_by_money")
    val costsPerSegmentByMoney: Double,
    @JsonProperty("costs_round_trip_by_money")
    val costsRoundTripByMoney: Double,
    @JsonProperty("value_of_million")
    val valueOfMillion: Double,
    @JsonProperty("boarding_fee")
    val boardingFee: Double,
    @JsonProperty("passenger_numbers")
    val passengerNumbers: Int
)