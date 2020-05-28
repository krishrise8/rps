package com.onboarding.rockpaperscissors.service

import com.onboarding.rockpaperscissors.model.History
import com.onboarding.rockpaperscissors.repository.HistoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class HistoryService{

    @Autowired
    private lateinit var historyRepository: HistoryRepository

    fun getAllHistory(name : String) : List<History>{
        return historyRepository.findByPlayerOneEqualsOrPlayerTwoEquals(name, name)
    }
}