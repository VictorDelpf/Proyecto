package com.example.desguacespaquito.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.desguacespaquito.db.dao.CarDao
import com.example.desguacespaquito.model.Car

@Database(entities = [Car::class], version = 2)
abstract class AppDatabase: RoomDatabase() {
    companion object {
        val DATABASE_NAME = "coches"
    }
    abstract fun carDao(): CarDao
}