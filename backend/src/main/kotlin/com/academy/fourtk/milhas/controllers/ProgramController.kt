package com.academy.fourtk.milhas.controllers

import com.academy.fourtk.milhas.dtos.requesties.ProgramRequest
import com.academy.fourtk.milhas.dtos.responses.ProgramResponse
import com.academy.fourtk.milhas.services.IProgramService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
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
    @GetMapping("/all")
    fun getAllPrograms(
        @PageableDefault(size = 3, sort = ["name"], direction = Sort.Direction.ASC) pagination: Pageable
    ) : Page<ProgramResponse> {
        try {
            return IProgramService.getAllPrograms(pagination)
        } catch (e: Exception) {
            throw Exception("field required")
        }
    }
}