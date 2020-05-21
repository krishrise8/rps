package com.onboarding.rockpaperscissors.controller

import com.onboarding.rockpaperscissors.model.Game
import com.onboarding.rockpaperscissors.service.GameService
import org.springframework.web.bind.annotation.*
import com.onboarding.rockpaperscissors.model.Round
import java.text.SimpleDateFormat
import java.util.*

@RestController
@RequestMapping("/game")
class GameController (){

    @CrossOrigin
    @PostMapping("/play/")
    fun play(@RequestBody game: Game) : Round{
        var gameService = GameService()
        return gameService.play(game.player1Choice, game.player2Choice, game.roundId);
    }

}