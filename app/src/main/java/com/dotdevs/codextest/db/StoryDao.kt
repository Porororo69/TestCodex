package com.dotdevs.codextest.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.dotdevs.codextest.model.StoryResponse

@Dao
interface StoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(story: StoryResponse): Long

    @Query("SELECT * FROM story")
    fun getAllStories(): LiveData<List<StoryResponse>>

    @Delete
    suspend fun deleteStory(story: StoryResponse)

}