package com.academy.fourtk.milhas.builders

import com.academy.fourtk.milhas.dtos.requesties.PayloadMilesRequest
import com.academy.fourtk.milhas.dtos.responses.PayloadMilesResponse
import com.academy.fourtk.milhas.entitites.Miles
import com.academy.fourtk.milhas.exceptions.NotFoundException
import com.academy.fourtk.milhas.repositories.ProgramRepository
import com.academy.fourtk.milhas.utills.formatDate
import java.time.LocalDateTime

fun milesBuilder(request: PayloadMilesRequest, repository: ProgramRepository) = Miles(
    program = repository.findByName(request.programName).orElseThrow{ NotFoundException("Program by name ${request.programName} not found") },
    originMiles = request.originMiles,
    amountPaid = request.amountPaid,
    quantityMiles = request.quantityMiles,
    description = request.description,
    thousandCost = request.thousandCost,
    startDate = LocalDateTime.now()
)

fun milesResponseBuilder(miles: Miles) = PayloadMilesResponse(
    originMiles = miles.originMiles.name,
    quantityMiles = miles.quantityMiles,
    amountPaid = miles.amountPaid,
    thousandCost = miles.thousandCost,
    startDate = formatDate(miles.startDate),
)