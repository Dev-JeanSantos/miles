package com.academy.fourtk.milhas.factories

import com.academy.fourtk.milhas.dtos.responses.PayloadEmissionResponse
import com.academy.fourtk.milhas.entitites.Emission
import com.academy.fourtk.milhas.enums.StatusFlightEmissions

object EmisisonBuilder {
    fun compareEmission(emission: Emission) = PayloadEmissionResponse(
        totalPoints = 2000.0,
        totalConversionCost = 4000.0,
        totalCashValue = 5000.0,
        passengerNumbers = 1,
        statusFlightEmissions = StatusFlightEmissions.IT_PAYS_TO_PAY_WITH_MILES
    )
}