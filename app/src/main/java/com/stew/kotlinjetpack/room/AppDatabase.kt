package com.stew.kotlinjetpack.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Created by stew on 5/22/22.
 * mail: stewforani@gmail.com
 */
@Database(entities = [Student::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun StudentDao(): StudentDao

    companion object {

        @Volatile private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                AppDatabase::class.java, "AppDatabase.db")
                .build()
    }
}