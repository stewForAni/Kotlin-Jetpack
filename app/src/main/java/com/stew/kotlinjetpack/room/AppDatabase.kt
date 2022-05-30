package com.stew.kotlinjetpack.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.stew.kotlinjetpack.MyApp
import com.stew.kotlinjetpack.room.githubproject.GithubProjectDao
import com.stew.kotlinjetpack.room.githubproject.GithubProjectEntity
import com.stew.kotlinjetpack.room.student.Student
import com.stew.kotlinjetpack.room.student.StudentDao

/**
 * Created by stew on 5/22/22.
 * mail: stewforani@gmail.com
 */
@Database(entities = [Student::class, GithubProjectEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun StudentDao(): StudentDao
    abstract fun GithubProjectDao(): GithubProjectDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(): AppDatabase =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: buildDatabase().also { INSTANCE = it }
                }

        private fun buildDatabase() =
                Room.databaseBuilder(MyApp.getInstance(),
                        AppDatabase::class.java, "AppDatabase.db")
                        .build()
    }
}