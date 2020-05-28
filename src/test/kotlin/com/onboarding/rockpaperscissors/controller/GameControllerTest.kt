package com.onboarding.rockpaperscissors.controller

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.google.gson.Gson
import com.onboarding.rockpaperscissors.model.Game
import com.onboarding.rockpaperscissors.model.History
import com.onboarding.rockpaperscissors.model.Round
import com.onboarding.rockpaperscissors.repository.HistoryRepository
import com.onboarding.rockpaperscissors.service.GameService
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.servlet.MockMvc
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.given
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.util.AssertionErrors.assertEquals
import org.springframework.test.web.servlet.post
import java.sql.Timestamp
import java.time.Instant
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*


@ExtendWith(SpringExtension::class)
@WebMvcTest(GameController::class)
class GameControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var gameService: GameService

    @MockBean
    private lateinit var historyRepository: HistoryRepository

    @Test
    fun givenGameController_whenPressScore_ShouldReturnResult() {

        var shapeChoices = Game("P1", "ROCK", "P2", "SCISSORS", 0)
        var jsonData = jacksonObjectMapper().writeValueAsString(shapeChoices)

        var result = mockMvc.post("/game/play"){
            contentType = MediaType.APPLICATION_JSON
            content = jsonData
        }.andExpect {
            status { isOk }
        }.andReturn();

        var expectedRound = Round(1,0, "P1")
        given(gameService.play("P1", "ROCK","P2", "SCISSORS", 0)).willReturn(expectedRound)

        var resultingContent = result.response.contentAsString

        val gson = Gson()
        val expectedString : String = gson.toJson(expectedRound)

        assertEquals("Testing post endpoint", expectedString, resultingContent)
    }

    @Test
    fun givenGameController_whenSaveHistory_ShouldReturnResult() {

        var history = History(1, "A", "B", "A", Timestamp(1590620298725L))
        var jsonData = jacksonObjectMapper().writeValueAsString(history)


        var result = mockMvc.post("/game/saveHistory"){
            contentType = MediaType.APPLICATION_JSON
            content = jsonData
        }.andExpect {
            status { isOk }
        }.andReturn();

        var historyObj = History(1, "A", "B", "A", Timestamp(1590620298725L))
        given(historyRepository.save(historyObj)).willReturn(historyObj)

        var resultingContent = result.response.contentAsString

        val gson = Gson()
        val expectedString : String = gson.toJson(historyObj)

        assertEquals("Testing post endpoint", expectedString, resultingContent)
    }

}