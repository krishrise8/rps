package com.onboarding.rockpaperscissors.service

import com.onboarding.rockpaperscissors.model.Game
import com.onboarding.rockpaperscissors.model.Round
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.util.AssertionErrors.assertEquals
import java.lang.IllegalArgumentException

@ExtendWith(SpringExtension::class)
class GameServiceTest {

    @Test
    fun givenValidShapes_AndPressScore_Player1Wins() {
        val gameService = GameService()
        val Shape1 = "SCISSORS"
        val Shape2 = "PAPER"
        val result = gameService.play("P1", Shape1, "P2", Shape2, 0)
        val expected = Round(1, 0, "P1")
        assertEquals("Valid Shapes Player 1 Wins Test", expected, result)
    }

    @Test
    fun givenValidShapes_AndPressScore_Player2Wins() {
        val gameService = GameService()
        val Shape1 = "PAPER"
        val Shape2 = "SCISSORS"
        val result = gameService.play("P1", Shape1, "P2", Shape2, 0)
        val expected = Round(2, 0, "P2")
        assertEquals("Valid Shapes Player 2 Wins Test", expected, result)
    }

    @Test
    fun givenValidShapes_AndPressScore_Player1Draw() {
        val gameService = GameService()
        val Shape1 = "SCISSOR"
        val Shape2 = "SCISSOR"
        val result = gameService.play("P1", Shape1, "P2", Shape2, 0)
        val expected = Round(0, 0, "")
        assertEquals("Valid Shapes Player 1 Draws with Player 2", expected, result)
    }

    @Test
    fun givenInvalidShapePlayer1_AndEmptyPlayer2_Error() {
        val gameService = GameService()
        val InvalidShape1 = "SCIZZOR"
        val InvalidShape2 = ""
        assertThrows<IllegalArgumentException> {
            gameService.play("P1", InvalidShape1, "P2", InvalidShape2, 0)
        }
    }

}