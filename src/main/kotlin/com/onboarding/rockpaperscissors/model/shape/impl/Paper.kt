package com.onboarding.rockpaperscissors.model.shape.impl

import com.onboarding.rockpaperscissors.model.shape.Shape

class Paper : Shape {
    override fun play(opponent: Shape): Any {
        if (opponent::class == Scissors:: class) {
            return -1
        } else if (opponent::class == Rock::class) {
            return 1
        } else {
            return 0;
        }
    }

    override fun name(): String {
        return "PAPER"
    }

}