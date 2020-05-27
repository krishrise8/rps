package com.onboarding.rockpaperscissors.service

import com.onboarding.rockpaperscissors.model.shape.impl.Paper
import com.onboarding.rockpaperscissors.model.shape.impl.Rock
import com.onboarding.rockpaperscissors.model.shape.impl.Scissors
import com.onboarding.rockpaperscissors.model.shape.Shape
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException
import com.onboarding.rockpaperscissors.model.Round

@Service
class GameService{

    fun play(firstName: String, firstChoice: String, secondName: String, secondChoice: String, roundId:Number) : Round  {
        var result = Round(0,0, "")

        try{
            val firstShape = convertToShape(firstChoice.toUpperCase())
            val secondShape = convertToShape(secondChoice.toUpperCase())


            when (firstShape.play(secondShape)) {
                1 -> result = Round(1, roundId, firstName )
                -1 -> result = Round(2, roundId, secondName)
                else -> result = Round(0, roundId, "")
            }
        }catch(e : Exception ){
            println("Something went wrong$e")
            throw java.lang.IllegalArgumentException(e)
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