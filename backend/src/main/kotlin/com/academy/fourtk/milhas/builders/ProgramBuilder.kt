package com.academy.fourtk.milhas.builders

import com.academy.fourtk.milhas.documents.ProgramDocument
import com.academy.fourtk.milhas.dtos.requesties.ProgramRequest
import com.academy.fourtk.milhas.dtos.responses.ProgramResponse
import com.academy.fourtk.milhas.entitites.Program
import java.time.LocalDateTime

fun programBuilder(programRequest: ProgramRequest) = Program(
    startDate = LocalDateTime.now(),
    name = programRequest.name,
    memberNumber = programRequest.memberNumber,
    officialValueOfMillion = programRequest.officialValueOfMillion,
    unofficialValueOfMillion = programRequest.unofficialValueOfMillion,
    programType = programRequest.programType
)

fun programResponseBuilder(program: Program) = ProgramResponse(
    startDate = LocalDateTime.now(),
    name = program.name,
    memberNumber = program.memberNumber,
    officialValueOfMillion = program.officialValueOfMillion,
    unofficialValueOfMillion = program.unofficialValueOfMillion,
    programType = program.programType,
    points = program.points,
    endDate = program.endDate,

)

fun programBuilderProgramResponse(programResponse: ProgramResponse) = Program(
    startDate = LocalDateTime.now(),
    name = programResponse.name,
    memberNumber = programResponse.memberNumber,
    officialValueOfMillion = programResponse.officialValueOfMillion,
    unofficialValueOfMillion = programResponse.unofficialValueOfMillion,
    programType = programResponse.programType,
    points = programResponse.points,
    endDate = programResponse.endDate,

    )

fun entityToDocument(entity: Program) = ProgramDocument(
    startDate = LocalDateTime.now(),
    name = entity.name,
    memberNumber = entity.memberNumber,
    officialValueOfMillion = entity.officialValueOfMillion,
    unofficialValueOfMillion = entity.unofficialValueOfMillion,
    programType = entity.programType
)