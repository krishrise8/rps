package com.onboarding.rockpaperscissors.repository

import com.onboarding.rockpaperscissors.model.WinnerHistory
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.*

@ExtendWith(SpringExtension:: class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
class RepositoriesTests @Autowired constructor(
        val entityManager: TestEntityManager,
        val winnerHistoryRepository: WinnerHistoryRepository) {

    @Test
    fun `testFind`() {

        val entityObj = WinnerHistory(1,"Joe", "Mike", "Joe", Date())
        entityManager.persist(entityObj)
        entityManager.flush()
        val found = winnerHistoryRepository.findAllById(1)
        println(found)
    }
}