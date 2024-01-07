package com.academy.fourtk.milhas.dtos.responses

import com.academy.fourtk.milhas.dtos.entities.Ok
import com.academy.fourtk.milhas.exceptions.BadRequestErrorResponse

class MultiplierResponse(
    val ok: Ok? = null,
    val multiplier: Double? = null,
    val badRequestErrorResponse: BadRequestErrorResponse? = null,
){
    companion object{
        fun of(ok: Ok): MultiplierResponse = MultiplierResponse(ok = ok)
        fun of(badRequestErrorResponse: BadRequestErrorResponse): MultiplierResponse = MultiplierResponse(badRequestErrorResponse = badRequestErrorResponse)
    }
}
