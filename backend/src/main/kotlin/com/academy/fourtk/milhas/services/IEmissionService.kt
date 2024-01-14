package com.academy.fourtk.milhas.services

import com.academy.fourtk.milhas.dtos.requesties.PayloadEmissionRequest
import com.academy.fourtk.milhas.dtos.responses.PayloadEmissionResponse

interface IEmissionService {
    fun compareEmission(data: PayloadEmissionRequest): PayloadEmissionResponse

}
