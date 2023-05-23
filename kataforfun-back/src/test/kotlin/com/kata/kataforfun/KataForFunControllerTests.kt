package com.kata.kataforfun

import com.kata.kataforfun.controllers.KataForFunController
import com.kata.kataforfun.services.KataForFunService
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest(KataForFunController::class)
class KataForFunControllerTests {

    @MockkBean
    lateinit var kataForFunService: KataForFunService;
    @Autowired
    private  lateinit var mockMvc: MockMvc;

    @Test
    fun convertNumberTestMatch(){
        every { kataForFunService.convertNumber(33) } returns "katakatakata" ;

        mockMvc.perform(get("/kata-for-fun/33"))
            .andExpect(status().isOk)
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.result").value("katakatakata"));

    }

    @Test
    fun convertNumberTestNoMatch(){
        every { kataForFunService.convertNumber(1) } returns "1" ;

        mockMvc.perform(get("/kata-for-fun/1"))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.result").value("1"));

    }

}

