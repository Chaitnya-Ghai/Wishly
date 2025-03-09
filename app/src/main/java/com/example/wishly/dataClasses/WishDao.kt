package com.example.wishly.dataClasses

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
abstract class WishDao {
    //    onConflict => strategy option
    //    if i try to add a wish , if wish already exits
    //    then via onConflict we set the strategy

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun addWish(wish:Wish)

    @Query("SELECT * FROM WishTable")
    abstract fun getWishList():Flow<List<Wish>>

    @Update
    abstract suspend fun updateWish(wish: Wish)

    @Delete
    abstract suspend fun deleteWish(wish: Wish)

    @Query("SELECT * FROM WishTable WHERE id = :id")
    abstract fun getWishById(id:Long): Flow<Wish>
}




//for query operations , they uses the Flow reactive stream like LiveData.
//it is a part of kotlin coroutines library
//and designed to provide a
// simple and efficient way to
// handle asynchronous data streams in reactive way.
// works well with Room
// To Fetch & Update data from database



//im using suspend functions
// where i'm not using the reactive stream like LiveData
// for fetching data from database