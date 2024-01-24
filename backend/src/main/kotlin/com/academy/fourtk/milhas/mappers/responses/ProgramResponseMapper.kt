package com.academy.fourtk.milhas.mappers.responses

import com.academy.fourtk.milhas.dtos.responses.ProgramResponse
import com.academy.fourtk.milhas.entitites.Program
import com.academy.fourtk.milhas.mappers.Mapper
import org.springframework.stereotype.Component

@Component
class ProgramResponseMapper : Mapper<Program, ProgramResponse> {
    override fun map(t: Program): ProgramResponse {
        return ProgramResponse(
            name = t.name,
            memberNumber = t.memberNumber,
            points = t.points,
            officialValueOfMillion = t.unofficialValueOfMillion,
            unofficialValueOfMillion = t.unofficialValueOfMillion,
            programType = t.programType,
            startDate = t.startDate,
            endDate = t.endDate
        )
    }
}