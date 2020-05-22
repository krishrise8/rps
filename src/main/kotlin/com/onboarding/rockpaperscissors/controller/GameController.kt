package com.onboarding.rockpaperscissors.controller

import com.onboarding.rockpaperscissors.model.Game
import com.onboarding.rockpaperscissors.service.GameService
import org.springframework.web.bind.annotation.*
import com.onboarding.rockpaperscissors.model.Round
import org.springframework.http.MediaType
import java.text.SimpleDateFormat
import java.util.*

@RestController
@RequestMapping("/game")
class GameController (){

    @PostMapping("/play", produces = arrayOf("application/json"))
    @CrossOrigin
    fun play(@RequestBody game: Game) : Round{
        var gameService = GameService()
        var round = gameService.play(game.player1Choice, game.player2Choice, game.roundId);
        return round;
    }

}