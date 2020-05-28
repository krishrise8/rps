package com.onboarding.rockpaperscissors.model

import java.sql.Timestamp
import java.time.Instant
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class History(
        @Id @GeneratedValue val id: Int,
        val playerOne: String,
        val playerTwo: String,
        val winner: String,
        val date: Timestamp

)