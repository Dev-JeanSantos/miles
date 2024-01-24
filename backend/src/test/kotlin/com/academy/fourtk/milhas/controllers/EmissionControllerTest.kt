package com.academy.fourtk.milhas.controllers

import com.academy.fourtk.milhas.dtos.requesties.PayloadEmissionRequest
import com.academy.fourtk.milhas.factories.EmisisonBuilder
import com.academy.fourtk.milhas.services.IEmissionService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers
import org.mockito.BDDMockito
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DisplayName("Controller Tests")
class EmissionControllerTest(
    @InjectMocks
    private val controller: EmissionController,

    @Mock
    private val service: IEmissionService
){
//    @BeforeEach
//    fun SetUp(){
//        BDDMockito.`when`(service.compareEmission(ArgumentMatchers.any(PayloadEmissionRequest::class.java)))
//            .then(EmisisonBuilder.compareEmission())
//    }

}