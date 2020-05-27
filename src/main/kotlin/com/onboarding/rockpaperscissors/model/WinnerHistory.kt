package com.onboarding.rockpaperscissors.model
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class WinnerHistory(
        @Id @GeneratedValue val id: Long,
        val playerOne: String,
        val playerTwo: String,
        val winner: String,
        val date: Date
)