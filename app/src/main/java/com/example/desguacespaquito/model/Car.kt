package com.example.desguacespaquito.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "car")
data class Car(
    @PrimaryKey val numberPlate: String,
    @ColumnInfo("year") val year: Int,
    @ColumnInfo("brand") val brand: String,
    @ColumnInfo("model") val model: String,
    @ColumnInfo("color") val color: String,
    @ColumnInfo("customerId") val customerId: Int
)
