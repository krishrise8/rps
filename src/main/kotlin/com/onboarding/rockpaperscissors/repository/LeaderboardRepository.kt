package com.onboarding.rockpaperscissors.repository

import com.onboarding.rockpaperscissors.model.Leaderboard
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface LeaderboardRepository : CrudRepository<Leaderboard, Long> {
    fun findByUser(user: String) : Leaderboard
    fun findAllByGamesGreaterThan(limit : Int): Iterable<Leaderboard>
}