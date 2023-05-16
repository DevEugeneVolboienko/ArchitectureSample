package com.example.architectureexample.data.network

import com.example.architectureexample.domain.response.BookResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface BookApi {
    @GET("books")
    fun getBooksListBy(
        @Query("type") genre: String,
        @Query("limit") limit: Int = 0
    ): Single<List<BookResponse>>
}