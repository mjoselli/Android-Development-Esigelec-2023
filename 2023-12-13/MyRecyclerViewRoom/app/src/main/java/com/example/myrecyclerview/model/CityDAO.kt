package com.example.myrecyclerview.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface CityDAO {
    @Query("Select * from City")
    fun getAll() :List<City>
    @Insert
    fun insertAll(vararg city: City)
    @Update
    fun updateCity(city: City):Int
    @Delete
    fun deleteCity(city: City):Int
}