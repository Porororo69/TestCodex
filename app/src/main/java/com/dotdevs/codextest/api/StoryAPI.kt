package com.dotdevs.codextest.api

import com.dotdevs.codextest.model.StoryResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface StoryAPI {

    @GET("topstories.json")
    suspend fun getTopStories(): Response<List<Int>>

    @GET("item/{id}.json")
    suspend fun getStoryDetail(
        @Path("id")
        id: Int
    ): Response<StoryResponse>

}