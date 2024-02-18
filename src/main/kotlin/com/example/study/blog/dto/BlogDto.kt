package com.example.study.blog.dto

/**
 * 클라이언트 단과 직접적으로 데이터를 교환하는 클래스
 * 엔티티와 클라이언트를 이어주는 중간 역할
 * @author 유선영
 */
data class BlogDto (
    val query: String,
    val sort: String,
    val page: Int,
    val size: Int
)