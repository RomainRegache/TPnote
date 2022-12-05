package com.example.tpnote

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tpnote.model.Joueur
import com.example.tpnote.model.JoueurDao

@Database(entities = [Joueur::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun joueurDao(): JoueurDao?
}