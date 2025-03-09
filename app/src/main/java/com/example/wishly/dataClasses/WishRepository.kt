package com.example.wishly.dataClasses

import android.util.Log
import kotlinx.coroutines.flow.Flow

// Repository Class
class WishRepository(private val wishDao: WishDao) {
    suspend fun addWish(wish: Wish) {
        wishDao.addWish(wish)
    }
    fun getWishList(): Flow<List<Wish>> = wishDao.getWishList()

    suspend fun updateWish(wish: Wish) = wishDao.updateWish(wish)

    suspend fun deleteWish(wish: Wish) = wishDao.deleteWish(wish)

    fun getWishById(id: Long): Flow<Wish> = wishDao.getWishById(id)
}