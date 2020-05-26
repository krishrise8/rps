package com.onboarding.rockpaperscissors.model
import java.text.SimpleDateFormat
import java.util.*

data class Round(var winnerNumber: Number, var roundID : Number, var winnerName: String){
    var timestamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
}