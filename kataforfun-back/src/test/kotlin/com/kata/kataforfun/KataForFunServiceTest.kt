package com.kata.kataforfun

import com.kata.kataforfun.services.KataForFunService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


class KataForFunServiceTest {

    private val kataForFunService = KataForFunService();

    @Test
    fun convertNumberTest() {
        val nomatch = kataForFunService.convertNumber(1);
        val katakata = kataForFunService.convertNumber(3);
        val forInput = kataForFunService.convertNumber(5);
        val funInput = kataForFunService.convertNumber(7);
        val katafor = kataForFunService.convertNumber(51);
        val forkata = kataForFunService.convertNumber(53);
        val katakatakata = kataForFunService.convertNumber(33);
        val katafun = kataForFunService.convertNumber(27);
        val kataForFor = kataForFunService.convertNumber(15);
        Assertions.assertEquals("1", nomatch);
        Assertions.assertEquals("KataKata", katakata);
        Assertions.assertEquals("ForFor", forInput);
        Assertions.assertEquals("Fun", funInput);
        Assertions.assertEquals("KataFor", katafor);
        Assertions.assertEquals("ForKata", forkata);
        Assertions.assertEquals("KataKataKata", katakatakata);
        Assertions.assertEquals("KataFun", katafun);
        Assertions.assertEquals("KataForFor", kataForFor);
    }


}