package com.onboarding.rockpaperscissors.repository

import com.onboarding.rockpaperscissors.model.History
import com.onboarding.rockpaperscissors.model.Leaderboard
import org.assertj.core.api.Java6Assertions
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.sql.Timestamp

@ExtendWith(SpringExtension::class)
@DataJpaTest
class LeaderboardRepositoryTest {

    @Autowired
    private lateinit var testEntityManager: TestEntityManager

    @Autowired
    private lateinit var leaderboardRepository: LeaderboardRepository

    @Test
    fun givenHistoryJson_whenSaveLeaderboard_returnSavedLeaderboard() {
        //Given
        var leaderboard = Leaderboard("A", 1)
        testEntityManager.persist(leaderboard)

        //When
        val optionalLeaderboard = leaderboardRepository.save(leaderboard)

        //Then
        println("Save Leaderboard " + optionalLeaderboard.toString())

        var expectedLeaderboard = Leaderboard("A", 1)
        val leaderboardByName = leaderboardRepository.findByUser("A")
        println("Leaderboard by name " + leaderboardByName)
        Assertions.assertTrue(expectedLeaderboard.equals(leaderboardByName))

    }

}