package com.academy.fourtk.milhas.exceptions

import com.academy.fourtk.milhas.enums.ErrorType

class BadRequestErrorResponse(
    val type: ErrorType,
    val message: String?
    )

