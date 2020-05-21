package com.onboarding.rockpaperscissors.model
import java.text.SimpleDateFormat
import java.util.*

data class Round(var winner: Number, var roundID : Number){
    var timestamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
    //var winner : Number = 0
    //var loser : Number = 0
    //var roundID : Number = 0
}