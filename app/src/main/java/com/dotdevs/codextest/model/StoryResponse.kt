package com.dotdevs.codextest.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "story"
)
data class StoryResponse(
    @PrimaryKey(autoGenerate = true)
    var uid: Int? = null,
    val `by`: String,
    val descendants: Int,
    val id: Int,
    val kids: List<Int>,
    val score: Int,
    val time: Int,
    val title: String,
    val type: String,
    val url: String
)