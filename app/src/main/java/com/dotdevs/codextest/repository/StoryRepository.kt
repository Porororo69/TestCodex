package com.dotdevs.codextest.repository

import com.dotdevs.codextest.api.RetrofitInstance
import com.dotdevs.codextest.db.StoryDatabase

class StoryRepository(
    var db: StoryDatabase
) {

    suspend fun getTopStories() =
        RetrofitInstance.api.getTopStories()

    suspend fun getStoryDetail(id: Int) =
        RetrofitInstance.api.getStoryDetail(id)

}