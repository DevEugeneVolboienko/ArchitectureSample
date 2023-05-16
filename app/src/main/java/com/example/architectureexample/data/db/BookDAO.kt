package com.example.architectureexample.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.architectureexample.data.entity.BookEntity
import io.reactivex.Single

@Dao
interface BookDAO : BaseDAO<BookEntity> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(bookEntities: List<BookEntity>)

    @Query("SELECT * FROM book WHERE id LIKE :id")
    fun getBook(id: Int): BookEntity

    @Query("SELECT * FROM book WHERE genre LIKE :genre")
    fun selectAllByGenre(genre: String): Single<List<BookEntity>>

    @Query("SELECT * FROM book")
    fun selectAll(): Single<List<BookEntity>>

    @Query("delete from book")
    fun deleteAll()
}