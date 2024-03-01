package com.example.desguacespaquito.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "customer")
data class Customer(
    @PrimaryKey(autoGenerate = true) val id: Int= 0,
    @ColumnInfo("ussername") val user: String,
    @ColumnInfo("password") val password: String
)
