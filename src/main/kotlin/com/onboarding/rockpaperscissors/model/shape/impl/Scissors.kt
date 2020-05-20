package com.onboarding.rockpaperscissors.model.shape.impl

import com.onboarding.rockpaperscissors.model.shape.Shape
import com.onboarding.rockpaperscissors.model.shape.impl.Paper
import com.onboarding.rockpaperscissors.model.shape.impl.Rock

class Scissors : Shape {

    override fun play(opponent : Shape) : Int {
        if (opponent::class == Rock:: class) {
            return -1
        } else if (opponent::class == Paper::class) {
            return 1
        } else {
            return 0;
        }
    }

    override fun name(): String {
        return "SCISSORS"
    }

}