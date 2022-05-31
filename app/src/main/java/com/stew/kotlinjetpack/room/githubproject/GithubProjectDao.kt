package com.stew.kotlinjetpack.room.githubproject

import androidx.paging.PagingSource
import androidx.room.*

/**
 * Created by stew on 5/29/22.
 * mail: stewforani@gmail.com
 */

@Dao
interface GithubProjectDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(pokemonList: List<GithubProjectEntity>)

    @Query("SELECT * FROM GithubProjectTable")
    fun get(): PagingSource<Int, GithubProjectEntity>

    @Query("SELECT * FROM GithubProjectTable")
    fun get2(): List<GithubProjectEntity>

    @Query("DELETE FROM GithubProjectTable")
    suspend fun clear()

    @Delete
    fun delete(repo: GithubProjectEntity)

    @Update
    fun update(repo: GithubProjectEntity)

}