package com.onboarding.rockpaperscissors.model
import java.text.SimpleDateFormat
import java.util.*

data class Round(var winner: Number, var roundID : Number){
    var timestamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
}