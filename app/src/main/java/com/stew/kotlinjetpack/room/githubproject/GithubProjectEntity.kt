package com.stew.kotlinjetpack.room.githubproject

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by stew on 5/29/22.
 * mail: stewforani@gmail.com
 */
@Entity(tableName = "GithubProjectTable")
data class GithubProjectEntity(
        @PrimaryKey(autoGenerate = true)
        val databaseID: Int,

        val id: Int,
        val name: String,
        val description: String?,
        val stargazers_count: Int,
)
