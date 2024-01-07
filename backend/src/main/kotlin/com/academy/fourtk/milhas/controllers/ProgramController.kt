package com.academy.fourtk.milhas.controllers

import com.academy.fourtk.milhas.dtos.ProgramRequest
import com.academy.fourtk.milhas.dtos.ProgramResponse
import com.academy.fourtk.milhas.services.IProgramService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/programs")
class ProgramController(val IProgramService: IProgramService) {

    @PostMapping
    fun createProgram(@RequestBody request: ProgramRequest){
        return IProgramService.create(request)
    }

    @GetMapping
    fun getProgram(@RequestParam programName: String): ProgramResponse {
        return IProgramService.getProgram(programName)
    }
}