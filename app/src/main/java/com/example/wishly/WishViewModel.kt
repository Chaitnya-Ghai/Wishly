package com.example.wishly

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class WishViewModel:ViewModel(){

    var wishTitle by mutableStateOf("")
    var wishDescription  by mutableStateOf("")

    fun onWishTitleChange(newValue:String){
        wishTitle = newValue
    }
    fun onWishDescriptionChange(newValue:String){
        wishDescription = newValue
    }

//    private val wishlist = mutableListOf<Wish>()
//    fun getWishList():List<Wish>{
//        return wishlist
//    }
//    fun addWish(wish: Wish){
//        wishlist.add(wish)
//    }
//    fun removeWish(wish: Wish) {
//        wishlist.remove(wish)
//    }
}
