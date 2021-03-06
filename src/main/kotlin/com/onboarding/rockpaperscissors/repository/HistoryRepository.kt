package com.onboarding.rockpaperscissors.repository

import com.onboarding.rockpaperscissors.model.History
import org.springframework.stereotype.Repository
import org.springframework.data.repository.CrudRepository;


@Repository
interface HistoryRepository : CrudRepository<History, Long> {
    fun findById(id : Int): History
    fun findAllByPlayerOneEqualsOrPlayerTwoEquals(playerOneName : String, playerTwoName : String) : Iterable<History>
}