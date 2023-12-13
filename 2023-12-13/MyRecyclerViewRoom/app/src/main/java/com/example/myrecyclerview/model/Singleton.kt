package com.example.myrecyclerview.model

import android.content.Context

object Singleton {
    lateinit var cities:List<City>
    lateinit var dao: CityDAO
    fun initializeDatabase(context: Context){
        CityDatabase.getInstance(context)?.apply {
            dao = cityDao()
            cities = dao.getAll()
        }
    }
    fun addCity(city: City){
        dao.insertAll(city)
        cities = dao.getAll()
    }
    fun updateCity(city: City){
        dao.updateCity(city)
        cities = dao.getAll()
    }
    fun deleteCity(city: City){
        dao.deleteCity(city)
        cities = dao.getAll()
    }
}
