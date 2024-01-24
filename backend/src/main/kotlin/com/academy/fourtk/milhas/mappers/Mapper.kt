package com.academy.fourtk.milhas.mappers

interface Mapper<T, U> {
    fun map(t: T): U
}
