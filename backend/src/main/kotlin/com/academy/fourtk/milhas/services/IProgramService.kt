package com.academy.fourtk.milhas.services

import com.academy.fourtk.milhas.dtos.ProgramRequest
import com.academy.fourtk.milhas.dtos.ProgramResponse

interface IProgramService {
    fun create(request: ProgramRequest)
    fun getProgram(programName: String): ProgramResponse

}
