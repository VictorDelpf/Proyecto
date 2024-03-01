package com.example.desguacespaquito.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation


data class CustomersWCars(
    @Embedded val customer: Customer,
    @Relation(
        parentColumn = "id",
        entityColumn = "customerId"
    )
    val cars: List<Car>
)
