package com.reco.upbox.dto

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

/**
 * 수거 이력 등록 요청을 받는 DTO
 */
data class CollectionHistoryRequest(
    @field:NotBlank(message = "수거 장소명은 필수입니다.")
    val location: String,

    @field:NotBlank(message = "수거 날짜는 필수입니다.")
    val date: String,

    @field:NotNull(message = "수거량은 필수입니다.")
    @field:Min(value = 0, message = "수거량은 0 이상이어야 합니다.")
    val amount: Double
)

/**
 * 수거 이력 결과를 반환하는 DTO
 */
data class CollectionHistoryResponse(
    val location: String,
    val date: String,
    val amount: Double
)