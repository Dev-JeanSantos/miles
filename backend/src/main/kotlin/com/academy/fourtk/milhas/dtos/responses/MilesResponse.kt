package com.academy.fourtk.milhas.dtos.responses

import com.academy.fourtk.milhas.dtos.entities.Ok
import com.academy.fourtk.milhas.enums.Program
import com.academy.fourtk.milhas.exceptions.BadRequestErrorResponse
import com.fasterxml.jackson.annotation.JsonProperty

class MilesResponse(
    val ok: Ok? = null,
    val badRequestErrorResponse: BadRequestErrorResponse? = null,
    @JsonProperty("value_of_million")
    val valueOfMillion: Double? = null,
    val program: Program? = null
){
    companion object{
        fun of(ok: Ok): MilesResponse = MilesResponse(ok = ok)
        fun of(badRequestErrorResponse:BadRequestErrorResponse): MilesResponse = MilesResponse(badRequestErrorResponse = badRequestErrorResponse)
    }
}
