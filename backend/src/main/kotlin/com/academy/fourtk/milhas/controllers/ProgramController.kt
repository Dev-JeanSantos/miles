package com.academy.fourtk.milhas.controllers

import com.academy.fourtk.milhas.dtos.requesties.ProgramRequest
import com.academy.fourtk.milhas.dtos.responses.ProgramResponse
import com.academy.fourtk.milhas.services.IProgramService
import jakarta.validation.Valid
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/programs")
class ProgramController(val IProgramService: IProgramService) {

    @PostMapping
    fun createProgram(@Valid @RequestBody request: ProgramRequest) {
        return IProgramService.create(request)
    }

    @GetMapping
    fun getProgram(@RequestParam programName: String): ProgramResponse {
        try {
            return IProgramService.getProgram(programName)
        } catch (e: MissingServletRequestParameterException) {
            throw MissingServletRequestParameterException(programName, "field required")
        }
    }
}