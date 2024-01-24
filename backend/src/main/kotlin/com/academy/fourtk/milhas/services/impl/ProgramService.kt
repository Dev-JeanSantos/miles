package com.academy.fourtk.milhas.services.impl

import com.academy.fourtk.milhas.dtos.requesties.ProgramRequest
import com.academy.fourtk.milhas.dtos.responses.ProgramResponse
import com.academy.fourtk.milhas.exceptions.NotFoundException
import com.academy.fourtk.milhas.mappers.ProgramMapper
import com.academy.fourtk.milhas.mappers.responses.ProgramResponseMapper
import com.academy.fourtk.milhas.repositories.ProgramRepository
import com.academy.fourtk.milhas.services.IProgramService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ProgramService(
    val repository: ProgramRepository,
    val programMapper: ProgramMapper,
    val programResponseMapper: ProgramResponseMapper
    ) : IProgramService {

    override fun create(request: ProgramRequest) {
        try {
            val program = programMapper.map(request)
            repository.save(program)
        } catch (e: NotFoundException) {
            NotFoundException("program already exists")
        }
    }

    override fun getProgram(programName: String): ProgramResponse {
        val possibleProgram = repository.findByName(programName)
            .orElseThrow { NotFoundException("Program by name $programName not found") }
        return programResponseMapper.map(possibleProgram)
    }
    override fun getAllPrograms(pagination: Pageable): Page<ProgramResponse> {
        val programs = repository.findAll(pagination)
        return programs.map { t -> programResponseMapper.map(t)}
    }
}
