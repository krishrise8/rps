package com.onboarding.rockpaperscissors.service

import com.onboarding.rockpaperscissors.model.shape.impl.Paper
import com.onboarding.rockpaperscissors.model.shape.impl.Rock
import com.onboarding.rockpaperscissors.model.shape.impl.Scissors
import com.onboarding.rockpaperscissors.model.shape.Shape
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException

@Service
class GameService{

    fun play(first: String, second: String) : String  {
        var result = ""
        try{
            val firstShape = convertToShape(first.toUpperCase())
            val secondShape = convertToShape(second.toUpperCase())

            when (firstShape.play(secondShape)) {
                1 -> result = "Player 1 wins"
                -1 -> result = "Player 2 wins"
                else -> result = "Draw. Play Again"
            }
        }catch(e : Exception ){
            return "Something went wrong"
        }

        return result
    }

    private fun convertToShape(shape: String): Shape {
        when(shape){
            Rock().name() -> return Rock()
            Paper().name() -> return Paper()
            Scissors().name() -> return Scissors()
            else -> throw IllegalArgumentException("Something went wrong")
        }
    }
}