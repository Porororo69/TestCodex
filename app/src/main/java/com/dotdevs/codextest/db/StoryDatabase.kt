package com.dotdevs.codextest.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dotdevs.codextest.model.StoryResponse

@Database(
    entities = [StoryResponse::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class StoryDatabase: RoomDatabase() {

    abstract fun getStoryDao(): StoryDao

    companion object{
        @Volatile
        private var instance: StoryDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                StoryDatabase::class.java,
                "story_db.db"
            ).build()
    }
}