package com.example.tpnote.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface MatchDao {
    @get:Query("SELECT * FROM `match`")
    val all: List<Match>

    @Insert
    fun insertAll(vararg matchs: Match)
}