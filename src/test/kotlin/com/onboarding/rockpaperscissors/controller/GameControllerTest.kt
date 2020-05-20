package com.onboarding.rockpaperscissors.controller

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.onboarding.rockpaperscissors.model.Game
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


@ExtendWith(SpringExtension::class)
@WebMvcTest(GameController::class)
class GameControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var gameService: GameService

    @Test
    fun givenGameController_whenPressScore_ShouldReturnResult() {

        var shapeChoices = Game("PAPER", "ROCK")
        var jsonData = jacksonObjectMapper().writeValueAsString(shapeChoices)

        var result = mockMvc.post("/game/play"){
            contentType = MediaType.APPLICATION_JSON
            content = jsonData
        }.andExpect {
            status { isOk }
        }.andReturn();

        var expectedContent = "Player 1 wins"
        given(gameService.play("PAPER", "ROCK")).willReturn(expectedContent)

        var resultingContent = result.response.contentAsString
        assertEquals("Testing post endpoint", expectedContent, resultingContent)
    }

}