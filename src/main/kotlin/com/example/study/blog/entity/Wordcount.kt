package com.example.study.blog.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id

/**
 * 데이터베이스 테이블에 존재하는 컬럼을 필드로 가지는 객체 
 * 실제 db 테이블과 매핑되는 클래스
 * @author 유선영
 */
@Entity
class Wordcount (
    @Id val word: String,
    val cnt: Int = 0
)