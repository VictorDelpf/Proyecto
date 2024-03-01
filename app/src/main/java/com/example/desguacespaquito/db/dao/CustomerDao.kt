package com.example.desguacespaquito.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.desguacespaquito.model.Car
import com.example.desguacespaquito.model.Customer

@Dao
interface CustomerDao {
    @Query("SELECT * FROM customer")
    fun list(): List<Customer>
    @Insert
    fun save(customer: Customer)
    @Query("SELECT Count(*) from customer WHERE ussername=:ussername AND password=:password")
    fun inicio(ussername: String, password: String): Int
}