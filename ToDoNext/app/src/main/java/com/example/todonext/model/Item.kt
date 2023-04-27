package com.example.todonext.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item (
     @PrimaryKey (autoGenerate = true)
     val id: Int?,
     var name: String,
     var isChecked: Boolean
)