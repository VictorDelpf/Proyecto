package com.example.desguacespaquito.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "customer")
data class Customer(
    @PrimaryKey val Id: String,
    @ColumnInfo("ussername") val user: String,
    @ColumnInfo("password") val password: String,
)
