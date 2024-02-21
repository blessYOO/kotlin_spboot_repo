package com.example.study.blog.dto

import com.example.study.core.annotation.ValidEnum
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

/**
 * 클라이언트 단과 직접적으로 데이터를 교환하는 클래스
 * 엔티티와 클라이언트를 이어주는 중간 역할
 * @author 유선영
 */
data class BlogDto (

    @field:NotBlank(message = "query parameter required")
    @JsonProperty("query")
    private val _query: String,

    @field:NotBlank(message = "sort parameter required")
    @field:ValidEnum(enumClass = EnumSort::class, message = "sort parameter one of ACCURACY and RECENCY")
    val sort: String,

    @field:NotNull(message = "page parameter required")
    @field:Max(50, message = "page is more than max")
    @field:Min(1, message = "page is least than min")
    val page: Int,

    @field:NotNull(message = "size parameter required")
    val size: Int
){

    val query: String
        get() = _query!!

    private enum class EnumSort{
        accuracy,
        recency
    }
}