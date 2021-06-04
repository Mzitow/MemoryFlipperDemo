package com.mzitow.flippergame

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.mzitow.flippergame.models.BoardSize
import com.mzitow.flippergame.models.MemoryCard


class MemoryBoardAdapter(
    private val context: Context,
    private val numberOfPieces: BoardSize,
    private val card: List<MemoryCard>
) :
    RecyclerView.Adapter<MemoryBoardAdapter.ViewHolder>() {


    companion object{
        private val MARGIN_SIZE = 10
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val cardWidth = parent.width / numberOfPieces.getWidth() - (2 * MARGIN_SIZE)
        val cardHeight = parent.height / numberOfPieces.getHeight() - (2 * MARGIN_SIZE)
        val  cardLength = kotlin.math.min(cardHeight, cardWidth)

       val view = LayoutInflater.from(context).inflate(R.layout.single_card, parent, false)

        val layoutParams = view.findViewById<MaterialCardView>(R.id.my_fipper).layoutParams as ViewGroup.MarginLayoutParams
        layoutParams.width = cardLength
        layoutParams.height = cardLength

        layoutParams.setMargins(MARGIN_SIZE, MARGIN_SIZE, MARGIN_SIZE, MARGIN_SIZE)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)


    }

    override fun getItemCount(): Int  = numberOfPieces.numberOfCards


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val  flipButton : ImageButton  = itemView.findViewById<ImageButton>(R.id.cell)

        fun bind(position: Int) {
            val  memoryCard  = card[position]
            flipButton.setImageResource(if (memoryCard.isFaceUp)  memoryCard.identifier else R.drawable.ic_launcher_background)

            flipButton.setOnClickListener{
                if (!memoryCard.isFaceUp)
                    flipButton.setImageResource(memoryCard.identifier)

            }
        }
    }
}
