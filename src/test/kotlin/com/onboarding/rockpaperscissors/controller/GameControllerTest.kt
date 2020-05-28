package com.onboarding.rockpaperscissors.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.google.gson.Gson
import com.ninjasquad.springmockk.MockkBean
import com.onboarding.rockpaperscissors.model.Game
import com.onboarding.rockpaperscissors.model.History
import com.onboarding.rockpaperscissors.model.Round
import com.onboarding.rockpaperscissors.repository.HistoryRepository
import com.onboarding.rockpaperscissors.service.GameService
import com.onboarding.rockpaperscissors.service.HistoryService
import io.mockk.every
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.util.AssertionErrors.assertEquals
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post
import java.sql.Timestamp
import java.util.*


@ExtendWith(SpringExtension::class)
@WebMvcTest(GameController::class)
class GameControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockkBean
    private lateinit var gameService: GameService

    @MockkBean
    private lateinit var historyRepository: HistoryRepository

    @MockkBean
    private lateinit var historyService: HistoryService

    @Autowired
    private val objectMapper: ObjectMapper? = null

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
    fun givenGameController_whenSaveHistory_ShouldReturnSavedHistory() {

        var history = History(0, "A", "B", "A", Timestamp(1590620298725L))
        var jsonData = jacksonObjectMapper().writeValueAsString(history)



        every{historyRepository.save(history)} returns history

        var result = mockMvc.post("/game/saveHistory"){
            contentType = MediaType.APPLICATION_JSON
            content = jsonData
        }.andExpect {
            status { isOk }
        }.andReturn();

    }

    @Test
    fun givenGameController_whenGetAllHistory_ShouldReturnResult() {

        var allHistory : List<History> = listOf(History(0, "A", "B", "A", Timestamp(1590620298725L)))

        every{historyService.getAllHistory("A")} returns allHistory

        var result = mockMvc.get("/game/getHistory/A")//.get("/game/getHistory/A"){
        .andExpect {
            status { isOk }
        }.andReturn();

        var resultingContent = result.response.contentAsString
        println(resultingContent)
    }

}