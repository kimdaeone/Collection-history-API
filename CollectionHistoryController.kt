package com.reco.upbox.controller

import com.reco.upbox.dto.CollectionHistoryRequest
import com.reco.upbox.dto.CollectionHistoryResponse
import com.reco.upbox.service.CollectionHistoryService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/history")
class CollectionHistoryController(
    private val service: CollectionHistoryService
) {
    // 1. 전체 이력 조회
    @GetMapping
    fun getHistoryList(): ResponseEntity<List<CollectionHistoryResponse>> {
        val list = service.getAllHistories()
        return ResponseEntity.ok(list)
    }

    // 2. 신규 이력 등록
    @PostMapping
    fun createHistory(@Valid @RequestBody request: CollectionHistoryRequest): ResponseEntity<CollectionHistoryResponse> {
        val savedData = service.saveHistory(request)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedData)
    }
}