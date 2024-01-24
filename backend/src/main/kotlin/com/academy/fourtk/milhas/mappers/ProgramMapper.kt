package com.academy.fourtk.milhas.mappers

import com.academy.fourtk.milhas.dtos.requesties.ProgramRequest
import com.academy.fourtk.milhas.entitites.Program
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class ProgramMapper : Mapper<ProgramRequest, Program> {
    override fun map(t: ProgramRequest): Program {
        return Program(
            startDate = LocalDateTime.now(),
            name = t.name,
            memberNumber = t.memberNumber,
            officialValueOfMillion = t.officialValueOfMillion,
            unofficialValueOfMillion = t.unofficialValueOfMillion,
            programType = t.programType
        )
    }
}
