package com.example.desguacespaquito.db.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Insert
import com.example.desguacespaquito.model.Car

@Dao
interface CarDao {
    @Query("SELECT * FROM car")
    fun listByCostumer(): List<Car>
    @Query("DELETE FROM car WHERE numberPlate=:numberPlate")
    fun delete(numberPlate: String)
    @Insert
    fun save(book: Car)
}