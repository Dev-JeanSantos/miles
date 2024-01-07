package com.academy.fourtk.milhas.services

import com.academy.fourtk.milhas.dtos.requesties.ProgramRequest
import com.academy.fourtk.milhas.dtos.responses.ProgramResponse

interface IProgramService {
    fun create(request: ProgramRequest)
    fun getProgram(programName: String): ProgramResponse

}
