package com.academy.fourtk.milhas.utills

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private val dt: DateTimeFormatter = DateTimeFormatter.ofPattern("dd:MM:yyyy HH:mm:ss")
fun formatDate(date: LocalDateTime): String{
    val dateFormat = dt.format(date)
    return dateFormat
}
