package com.onboarding.rockpaperscissors.model

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Leaderboard(
        @Id
        val user: String,
        val games: Int
)