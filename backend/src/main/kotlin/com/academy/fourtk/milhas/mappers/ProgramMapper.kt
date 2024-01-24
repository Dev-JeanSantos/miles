package com.academy.fourtk.milhas.mappers

import com.academy.fourtk.milhas.dtos.responses.ProgramResponse
import com.academy.fourtk.milhas.entitites.Program
import org.springframework.stereotype.Component

@Component
class ProgramMapper : Mapper<Program, ProgramResponse> {
    override fun map(t: Program): ProgramResponse {
        return ProgramResponse(
            name = t.name,
            memberNumber = t.memberNumber,
            points = t.points,
            officialValueOfMillion = t.unofficialValueOfMillion,
            unofficialValueOfMillion = t.unofficialValueOfMillion,
            programType = t.programType
        )
    }
}