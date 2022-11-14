package com.example.assessment_4662576_and_4645639.data_entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.w3c.dom.Text

@Entity
data class Car(
    @PrimaryKey(autoGenerate = true) val id:Int?,
    @ColumnInfo(name = "brand") val brand: String,
    @ColumnInfo(name = "model") val model: String,
    @ColumnInfo(name = "price") val price: String
)