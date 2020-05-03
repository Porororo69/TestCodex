package com.dotdevs.codextest.db

import androidx.room.TypeConverter

class Converters {

    @TypeConverter
    fun fromKids(kids: List<Int>): String{
        var commentIds = ""

        for(i in kids) commentIds += ",$i"

        return commentIds
    }

    @TypeConverter
    fun toKids(commentIds: String): List<Int> {
        val list = mutableListOf<Int>()

        val array = commentIds.split(",".toRegex()).dropLastWhile {
            it.isEmpty()
        }.toTypedArray()

        for (str in array){
            if (str.isNotEmpty()) list.add(str.toInt())
        }

        return list
    }
}