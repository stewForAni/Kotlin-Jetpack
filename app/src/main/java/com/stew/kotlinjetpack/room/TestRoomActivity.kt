package com.stew.kotlinjetpack.room

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.stew.kotlinjetpack.R
import com.stew.kotlinjetpack.room.student.Student
import kotlinx.coroutines.*

/**
 * Created by stew on 5/21/22.
 * mail: stewforani@gmail.com
 */
class TestRoomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)


        CoroutineScope(Dispatchers.Main).launch(Dispatchers.IO) {
            AppDatabase.getInstance(this@TestRoomActivity).StudentDao()
                .insertStudent(Student("stew", "30"))

            var list = AppDatabase.getInstance(this@TestRoomActivity).StudentDao().getStudentList()

            for(item in list){
                Log.d("TestRoomActivity", "onCreate: "+item.id)
            }

        }


    }
}