package com.onboarding.rockpaperscissors.repository

import com.onboarding.rockpaperscissors.model.WinnerHistory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface WinnerHistoryRepository: JpaRepository <WinnerHistory, Long> {

     fun findWinnerHistoriesByIdEquals(id: Int){}
    abstract fun findWinnerHistoriesByPlayerOne(name: String)
    abstract fun findAllById(id: Int): WinnerHistory
}