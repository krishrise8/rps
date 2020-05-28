package com.onboarding.rockpaperscissors.repository

import com.onboarding.rockpaperscissors.model.History
import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.sql.Timestamp
import java.util.*

@ExtendWith(SpringExtension::class)
@DataJpaTest
class HistoryRepositoryTest {

    @Autowired
    private lateinit var testEntityManager: TestEntityManager

    @Autowired
    private lateinit var historyRepository: HistoryRepository

    @Test
    fun givenHistoryJson_whenSaveHistory_returnSavedHistory() {
        //Given
        var history = History(0,"A", "B", "A", Timestamp(1590620298725L))
        testEntityManager.persist(history)

        //When
        val optionalHistory = historyRepository.save(history)

        //Then
        assertThat(optionalHistory).isNotNull()
        println("Save History" + optionalHistory.toString())

        var expectedHistory = History(0,"A", "B", "A", Timestamp(1590620298725L))
        val historyByID : History = historyRepository.findById(0)
        println("History by Id" + historyByID)
        assertTrue(expectedHistory.id.equals(historyByID.id))

    }

    @Test
    fun givenName_whenGetAllHistory_returnAllHistory() {
        //Given
        var history = History(0,"A", "B", "A", Timestamp(1590620298725L))
        testEntityManager.persist(history)

        //When
        val optionalHistory = historyRepository.save(history)
        val allHistory = historyRepository.findAllByPlayerOneEqualsOrPlayerTwoEquals("A", "A")

        //Then
        assertThat(optionalHistory).isNotNull()
        println("Save History" + optionalHistory.toString())

        println(allHistory.toString())

        var expectedHistory = History(1,"A", "B", "A", Timestamp(1590620298725L))
        val historyByID : History = historyRepository.findById(1)
        println("History by Id" + historyByID)
        //assertTrue(expectedHistory.equals(historyByID))

    }


}