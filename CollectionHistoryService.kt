package com.reco.upbox.service

import com.reco.upbox.dto.CollectionHistoryRequest
import com.reco.upbox.dto.CollectionHistoryResponse
import com.reco.upbox.repository.CollectionHistoryRepository
import org.springframework.stereotype.Service

@Service
class CollectionHistoryService(
    private val repository: CollectionHistoryRepository
) {
    fun getAllHistories(): List<CollectionHistoryResponse> {
        return repository.findAll()
    }

    fun saveHistory(request: CollectionHistoryRequest): CollectionHistoryResponse {
        return repository.save(request)
    }
}