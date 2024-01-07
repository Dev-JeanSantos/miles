package com.academy.fourtk.milhas.exceptions

import java.lang.RuntimeException

data class NotFoundException(override val message: String) : RuntimeException(message)
