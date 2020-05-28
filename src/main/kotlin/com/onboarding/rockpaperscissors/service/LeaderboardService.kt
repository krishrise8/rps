package com.onboarding.rockpaperscissors.service

import com.onboarding.rockpaperscissors.model.Leaderboard
import com.onboarding.rockpaperscissors.repository.LeaderboardRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service

@Service
class LeaderboardService {

    @Autowired
    private lateinit var leaderboardRepository: LeaderboardRepository

    fun incrementOrAddToLeaderboard(user: String): Boolean {

        try {
            var existingLeaderboard = leaderboardRepository.findByUser(user)
            var newLeaderboard = Leaderboard(user, existingLeaderboard.games + 1)
            leaderboardRepository.save(newLeaderboard)
            return true
        } catch (e: EmptyResultDataAccessException) {
            leaderboardRepository.save(Leaderboard(user, 1))
            return true
        } catch (e : Exception) {
            return false
        }

     }

}