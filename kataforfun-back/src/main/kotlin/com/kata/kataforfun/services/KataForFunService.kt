package com.kata.kataforfun.services

import org.springframework.stereotype.Component

@Component
class KataForFunService {

    val dict = mapOf(
        "3" to "Kata",
        "5" to "For",
        "7" to "Fun"
    )

    fun convertNumber(number: Int): String {
        var word = ""
        if (divisible(number, 3)) {
            word += "Kata"
        }
        if (divisible(number, 5)) {
            word += "For"
        }
        word += convertContains(number.toString(), dict)

        if (word.isEmpty()) {
            return number.toString()
        }
        return word
    }

    /**
     * takes input number and replaces each key number occurence with a string vlaue
     */
    fun convertContains(number: String, dict: Map<String, String>): String {
        var word = ""
        for (index in number.indices) {
            if (dict[number[index].toString()] != null) {
                word += dict[number[index].toString()]!!
            }
        }
        return word
    }


    fun divisible(number: Int, divisor: Int): Boolean {
        return number % divisor == 0
    }

}