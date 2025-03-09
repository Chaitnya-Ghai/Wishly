package com.example.wishly.dataClasses

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "WishTable")
data class Wish(
    @PrimaryKey(autoGenerate = true)
    val id :Long?=null,
    val title: String?="",
    val description: String?="",
)

