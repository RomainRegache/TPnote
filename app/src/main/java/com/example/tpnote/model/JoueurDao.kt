package com.example.tpnote.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface JoueurDao {
    @get:Query("SELECT * FROM joueur")
    val all: List<Joueur>

    @Insert
    fun insertAll(vararg joueurs: Joueur)
}