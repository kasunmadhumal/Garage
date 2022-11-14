package com.example.assessment_4662576_and_4645639.app_database

import android.widget.Toast
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.assessment_4662576_and_4645639.car_dao.CarDao
import com.example.assessment_4662576_and_4645639.data_entity.Car
import com.example.assessment_4662576_and_4645639.utils.MyApp
import java.sql.SQLException


@Database(entities = [Car::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun carDao(): CarDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getAppDatabase(): AppDatabase? {
            if (INSTANCE == null) {

                try {
                    INSTANCE = Room.databaseBuilder(
                        MyApp.context!!.applicationContext,
                        AppDatabase::class.java, "garage"
                    ).allowMainThreadQueries()
                        .build()

                } catch (exception:SQLException){
                    Toast.makeText(MyApp.context,"Can't create database", Toast.LENGTH_SHORT).show()
                }


            }

            return INSTANCE
        }

    }
}