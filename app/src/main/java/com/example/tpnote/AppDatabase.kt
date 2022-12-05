package com.example.tpnote

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Joueur::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun joueurDao(): JoueurDao?
}