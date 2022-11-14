package com.example.assessment_4662576_and_4645639.car_dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.assessment_4662576_and_4645639.data_entity.Car
import org.w3c.dom.Text

@Dao
interface CarDao {


    @Query("SELECT price FROM car WHERE brand = :car_brand AND model = :car_model")
    fun loadById(car_brand: String, car_model: String): String

    @Insert
    fun insertAll(vararg car: Car)

}