package com.onboarding.rockpaperscissors.controller

import com.onboarding.rockpaperscissors.model.Game
import com.onboarding.rockpaperscissors.model.History
import com.onboarding.rockpaperscissors.model.Leaderboard
import com.onboarding.rockpaperscissors.service.GameService
import org.springframework.web.bind.annotation.*
import com.onboarding.rockpaperscissors.model.Round
import com.onboarding.rockpaperscissors.repository.HistoryRepository
import com.onboarding.rockpaperscissors.repository.LeaderboardRepository
import com.onboarding.rockpaperscissors.service.HistoryService
import com.onboarding.rockpaperscissors.service.LeaderboardService
import org.springframework.beans.factory.annotation.Autowired
import java.security.Principal

@RestController
@RequestMapping("/game")
class GameController (){

    @Autowired
    private lateinit var historyService: HistoryService

    @Autowired
    private lateinit var historyRepository: HistoryRepository

    @Autowired
    private lateinit var leaderboardService : LeaderboardService

    @Autowired
    private lateinit var leaderboardRepository: LeaderboardRepository


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
    fun getAllHistory(@PathVariable name: String) : Iterable<History>{
        return historyService.getAllHistory(name)
    }

    @GetMapping("/saveLeaderboard/{user}")
    @CrossOrigin
    fun saveLeaderboard(@PathVariable user: String) : Boolean{
        return leaderboardService.incrementOrAddToLeaderboard(user)
    }

    @GetMapping("/getLeaderboard")
    @CrossOrigin
    fun getLeaderboard() : Iterable<Leaderboard>{
        return leaderboardRepository.findAll()
    }

    @GetMapping("/username")
    @ResponseBody
    fun getCurrentUserName(principal: Principal) : String{
        return principal.name
    }

}