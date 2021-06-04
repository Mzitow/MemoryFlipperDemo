package com.mzitow.flippergame.models

enum class BoardSize (val numberOfCards: Int){
    EASY(8),
    MEDIUM(18),
    HARD(24);

    fun getWidth(): Int = when(this){
        EASY -> 2
        MEDIUM -> 3
        HARD -> 4
    }

    fun getHeight():Int = numberOfCards / getWidth()

    fun getNumberOfPairs() : Int  = numberOfCards / 2
}