package com.mzitow.flippergame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.mzitow.flippergame.databinding.ActivityMainBinding
import com.mzitow.flippergame.models.BoardSize
import com.mzitow.flippergame.models.MemoryCard
import com.mzitow.flippergame.utils.DEFAULT_ICONS

class MainActivity : AppCompatActivity() {

     private  lateinit var binding: ActivityMainBinding
     private lateinit var  currentBoard : BoardSize

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        currentBoard = BoardSize.HARD

        //val memoryGame : MemoryGame
        val randomDefaultIcons = DEFAULT_ICONS.shuffled().take(currentBoard.getNumberOfPairs())
        val chosenImages = (randomDefaultIcons + randomDefaultIcons).shuffled()
        val randomaziedMemoryCards = chosenImages.map { MemoryCard(it) }

        binding.rvBoard.adapter  = MemoryBoardAdapter(this, currentBoard, randomaziedMemoryCards)
        binding.rvBoard.setHasFixedSize(true)
        binding.rvBoard.layoutManager = GridLayoutManager(this, currentBoard.getWidth())

    }
}