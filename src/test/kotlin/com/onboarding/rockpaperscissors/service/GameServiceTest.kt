package com.onboarding.rockpaperscissors.service

import com.onboarding.rockpaperscissors.model.Game
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
        val Shape1 = "SCISSOR"
        val Shape2 = "PAPER"
        val result = gameService.play(Shape1, Shape2)
        val expected = "Player 1 wins"
        assertEquals("Valid Shapes Player 1 Wins Test", expected, result)
    }

    @Test
    fun givenValidShapes_AndPressScore_Player2Wins() {
        val gameService = GameService()
        val Shape1 = "PAPER"
        val Shape2 = "SCISSOR"
        val result = gameService.play(Shape1, Shape2)
        val expected = "Player 2 wins"
        assertEquals("Valid Shapes Player 1 Wins Test", expected, result)
    }

    @Test
    fun givenValidShapes_AndPressScore_Player1Draw() {
        val gameService = GameService()
        val Shape1 = "SCISSOR"
        val Shape2 = "SCISSOR"
        val result = gameService.play(Shape1, Shape2)
        val expected = "Draw. Play Again"
        assertEquals("Valid Shapes Player 1 Draws with Player 2", expected, result)
    }

    @Test
    fun givenInvalidShapePlayer1_AndEmptyPlayer2_Error() {
        val gameService = GameService()
        val InvalidShape1 = "SCIZZOR"
        val InvalidShape2 = ""
        val exception = assertThrows<IllegalArgumentException> {
            gameService.play(InvalidShape1, InvalidShape2)
        }
        val expectedMessage = "Something went wrong"
        val actualMessage = exception.message
        assertEquals("Exception message is equal", expectedMessage, actualMessage)

    }

}