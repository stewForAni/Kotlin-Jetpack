package com.stew.kotlinjetpack.room

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by stew on 5/21/22.
 * mail: stewforani@gmail.com
 */
@Entity(tableName = "Student")
class Student(var name: String, var age: String) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}