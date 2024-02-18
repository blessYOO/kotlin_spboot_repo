package com.example.study.blog.service

import com.example.study.blog.dto.BlogDto
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono

@Service
class BlogService {

    @Value("\${REST_API_KEY}")
    var restApiKey: String = "97aa17ffd2263381e8bdf880b7de3958"

    fun searchKakao(blogDto: BlogDto): String? {
        println(blogDto.toString())
        val webClient = WebClient
            .builder()
            .baseUrl("https://dapi.kakao.com")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build()

        val response = webClient
            .get()
            .uri{ it.path("/v2/search/blog")
                .queryParam("query", blogDto.query)
                .queryParam("sort", blogDto.sort)
                .queryParam("page", blogDto.page)
                .queryParam("size", blogDto.size)
                .build()
            }
            .header("Authorization", "KakaoAK "+"$restApiKey")
            .retrieve()
            .bodyToMono<String>()

        val result = response.block()
        return result

        return "SearchKakao";
    }
}