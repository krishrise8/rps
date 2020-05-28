package com.onboarding.rockpaperscissors.controller

import com.onboarding.rockpaperscissors.model.Game
import com.onboarding.rockpaperscissors.model.History
import com.onboarding.rockpaperscissors.service.GameService
import org.springframework.web.bind.annotation.*
import com.onboarding.rockpaperscissors.model.Round
import com.onboarding.rockpaperscissors.repository.HistoryRepository
import com.onboarding.rockpaperscissors.service.HistoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

@RestController
@RequestMapping("/game")
class GameController (){

    @Autowired
    private lateinit var historyService: HistoryService

    @Autowired
    private lateinit var historyRepository: HistoryRepository

    @PostMapping("/play", produces = arrayOf("application/json"))
    @CrossOrigin
    fun play(@RequestBody game: Game) : Round{
        var gameService = GameService()
        var round = gameService.play(game.player1Name, game.player1Choice, game.player2Name, game.player2Choice, game.roundId);
        return round;
    }

    @PostMapping("/saveHistory")
    @CrossOrigin
    fun saveHistory(@RequestBody history: History) : History{
        return historyRepository.save(history)
    }

    @GetMapping("/getHistory/{name}")
    @CrossOrigin
    fun getAllHistory(@PathVariable name: String) : List<History>{
        return historyService.getAllHistory(name)
    }

}