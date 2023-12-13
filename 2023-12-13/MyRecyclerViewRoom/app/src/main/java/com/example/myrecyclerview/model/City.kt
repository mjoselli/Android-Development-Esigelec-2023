package com.example.myrecyclerview.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class City(
    @ColumnInfo(name = "name")
    var name:String,
    @ColumnInfo(name = "population")
    var population:Long
){
    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0
}

