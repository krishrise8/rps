package com.onboarding.rockpaperscissors.model

import java.sql.Timestamp
import javax.persistence.*

@Entity
data class History(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Int,
        @Column(name = "PLAYER_ONE")
        val playerOne: String,
        @Column(name = "PLAYER_TWO")
        val playerTwo: String,
        val winner: String,
        val date: Timestamp

)