package com.academy.fourtk.milhas.services.impl

import com.academy.fourtk.milhas.factories.payloadResponseBuilder
import com.academy.fourtk.milhas.dtos.requesties.PayloadEmissionRequest
import com.academy.fourtk.milhas.dtos.responses.PayloadEmissionResponse
import com.academy.fourtk.milhas.entitites.Emission
import com.academy.fourtk.milhas.enums.StatusFlightEmissions
import com.academy.fourtk.milhas.services.IEmissionService
import org.springframework.stereotype.Service

@Service
class EmissionService() : IEmissionService {
    override fun compareEmission(data: PayloadEmissionRequest): PayloadEmissionResponse {

        val totalPoints = calculateTotalPointsByNumberOfPassengers(data.totalPointsRoundTrip, data.passengerNumbers)

        val costsByPassengerForPoints = convertTotalMilesIntoCash(data.valueOfMillion, totalPoints)

        val costsAllPassengersForPoints = calculateCostOfIssuanceByPoints(costsByPassengerForPoints, data.boardingFee, data.passengerNumbers)

        val costsAllPassengersForMoney = data.costsRoundTripByMoney * data.passengerNumbers

        val statusFlightEmissions = if (costsAllPassengersForPoints < costsAllPassengersForMoney) {
            StatusFlightEmissions.IT_PAYS_TO_PAY_WITH_MILES
        } else {
            StatusFlightEmissions.IT_PAYS_WITH_CASH
        }

        val emission = Emission(
            totalPoints = totalPoints,
            totalConversionCost = costsAllPassengersForPoints,
            totalCashValue = costsAllPassengersForMoney,
            passengerNumbers = data.passengerNumbers,
            statusFlightEmissions = statusFlightEmissions
        )

        return payloadResponseBuilder(emission)
    }

    private fun calculateCostOfIssuanceByPoints(totalCashCostAllPassengers: Double, boardingFee: Double, passengersNumbers: Int ): Double {
        return (totalCashCostAllPassengers + (boardingFee  *  passengersNumbers))
    }

    private fun calculateTotalPointsByNumberOfPassengers(totalPoints: Double, passengersNumbers: Int): Double {
        return totalPoints * passengersNumbers
    }

    private fun convertTotalMilesIntoCash(valueOfMillion: Double, totalPointsRoundTrip: Double): Double {
        return (totalPointsRoundTrip * valueOfMillion) / MILHEIRO
    }
    companion object {
        const val MILHEIRO: Int = 1000
    }
}