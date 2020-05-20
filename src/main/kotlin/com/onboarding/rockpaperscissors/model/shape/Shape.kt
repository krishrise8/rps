package com.onboarding.rockpaperscissors.model.shape

interface Shape{
    fun play(opponent : Shape) : Any
    fun name():String
}