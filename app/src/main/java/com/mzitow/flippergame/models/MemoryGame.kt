package com.mzitow.flippergame.models

import com.mzitow.flippergame.utils.DEFAULT_ICONS

class MemoryGame(private val currentBoard: BoardSize) {

    lateinit var cards : List<MemoryCard>
    val numOfPairsFound = 0

    init {
        val randomDefaultIcons = DEFAULT_ICONS.shuffled().take(currentBoard.getNumberOfPairs())
        val chosenImages = (randomDefaultIcons + randomDefaultIcons).shuffled()
        val randomaziedMemoryCards = chosenImages.map { MemoryCard(it) }
    }
}