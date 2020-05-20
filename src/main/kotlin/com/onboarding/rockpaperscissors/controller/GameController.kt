package com.onboarding.rockpaperscissors.controller

import com.onboarding.rockpaperscissors.model.Game
import com.onboarding.rockpaperscissors.service.GameService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/game")
class GameController (){

    @CrossOrigin
    @PostMapping("/play")
    fun play(@RequestBody game: Game) : String{
        var gameService = GameService()
        return gameService.play(game.player1Choice, game.player2Choice);
    }

}