package com.onboarding.rockpaperscissors.repository

import com.onboarding.rockpaperscissors.model.History
import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.*

@ExtendWith(SpringExtension::class)
@DataJpaTest
class HotelRepositoryTest {

    @Autowired
    private lateinit var testEntityManager: TestEntityManager

    @Autowired
    private lateinit var historyRepository: HistoryRepository

    @Test
    fun it_should_find_history_by_name() {
        //Given
        var newDate = Calendar.getInstance().time
        val history = History(1,"Gabe","Matt", "Gabe", newDate)
        testEntityManager.persistAndFlush(history)

        //When
        //val optionalHistory = historyRepository.findByName("Gabe")

        //Then
        assertThat(optionalHistory).isNotNull()
//        val expectedHistory = optionalHistory.get()
//        assertThat(expectedHistory.).isNotNull()
//        assertThat(expectedHistory.).isEqualTo("Gabe")
//        assertThat(expectedHistory.).isEqualTo("Matt")
//        assertThat(expectedHistory.).isEqualTo("Gabe")
//        assertThat(expectedHistory.).isEqualTo(newDate)
    }
}