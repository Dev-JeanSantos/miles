package com.academy.fourtk.milhas.controllers

import com.academy.fourtk.milhas.dtos.requesties.PayloadEmissionRequest
import com.academy.fourtk.milhas.dtos.responses.PayloadEmissionResponse
import com.academy.fourtk.milhas.services.IEmissionService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/emissions/")
class EmissionController(val emissionService: IEmissionService) {
    @PostMapping("compare_emissions")
    fun compareFlightEmissions(@RequestBody data: PayloadEmissionRequest): PayloadEmissionResponse {
        return emissionService.compareEmission(data)
    }

}
