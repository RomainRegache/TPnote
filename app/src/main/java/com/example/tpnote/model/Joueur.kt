package com.example.tpnote.model

import androidx.room.ColumnInfo
import androidx.room.Entity

import androidx.room.PrimaryKey


@Entity
class Joueur {
    @PrimaryKey
    var uid = 0

    @ColumnInfo(name = "first_name")
    var firstName: String? = null
}