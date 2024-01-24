package com.academy.fourtk.milhas.services

import com.academy.fourtk.milhas.dtos.requesties.ProgramRequest
import com.academy.fourtk.milhas.dtos.responses.ProgramResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface IProgramService {
    fun create(request: ProgramRequest)
    fun getProgram(programName: String): ProgramResponse
    fun getAllPrograms(pagination: Pageable): Page<ProgramResponse>

}
