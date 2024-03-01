package com.example.desguacespaquito.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.desguacespaquito.db.dao.CarDao
import com.example.desguacespaquito.db.dao.CustomerDao
import com.example.desguacespaquito.model.Car
import com.example.desguacespaquito.model.Customer

@Database(entities = [Car::class,Customer::class], version = 2)
abstract class AppDatabase: RoomDatabase() {
    companion object {
        val DATABASE_NAME = "coches"
        val DATABASE_NAME2 = "customers"
    }
    abstract fun carDao(): CarDao
    abstract fun customerDao(): CustomerDao
}