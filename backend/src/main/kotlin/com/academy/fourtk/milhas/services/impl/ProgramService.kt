package com.academy.fourtk.milhas.services.impl

import com.academy.fourtk.milhas.factories.programBuilder
import com.academy.fourtk.milhas.factories.programResponseBuilder
import com.academy.fourtk.milhas.dtos.requesties.ProgramRequest
import com.academy.fourtk.milhas.dtos.responses.ProgramResponse
import com.academy.fourtk.milhas.exceptions.NotFoundException
import com.academy.fourtk.milhas.repositories.ProgramRepository
import com.academy.fourtk.milhas.services.IProgramService
import org.springframework.stereotype.Service

@Service
class ProgramService(val repository: ProgramRepository) : IProgramService {

    override fun create(request: ProgramRequest) {
        try {
            val program = programBuilder(request)
            repository.save(program)
        } catch (e: NotFoundException) {
            NotFoundException("program already exists")
        }
    }

    override fun getProgram(programName: String): ProgramResponse {
        val possibleProgram = repository.findByName(programName)
            .orElseThrow { NotFoundException("Program by name $programName not found") }
        return programResponseBuilder(possibleProgram)
    }
}
