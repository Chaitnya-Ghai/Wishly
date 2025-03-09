package com.example.wishly

import android.content.Context
import androidx.room.Room
import com.example.wishly.dataClasses.WishDatabase
import com.example.wishly.dataClasses.WishRepository

//in kt objects are singletons ,
//a singleton is a class of which only one instance will exists in tha application.
object Graph {
    lateinit var database : WishDatabase
    val wishRepository by lazy {
        WishRepository(wishDao = database.wishDao())
    }
    fun provide(context:Context){
        database = Room
            .databaseBuilder(
                context,
                WishDatabase::class.java,
                "WishDatabase")
            .allowMainThreadQueries()
            .build()
    }
}

//this graph obj is being used as
// service locator
// that will provide the dependencies to the rest
// of the app
