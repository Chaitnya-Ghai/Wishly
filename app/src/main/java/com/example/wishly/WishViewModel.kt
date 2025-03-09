package com.example.wishly

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wishly.dataClasses.Wish
import com.example.wishly.dataClasses.WishRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class WishViewModel(private val wishRepository: WishRepository = Graph.wishRepository) : ViewModel() {

    private val _getAllWishes = wishRepository.getWishList()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val getAllWishes: StateFlow<List<Wish>> = _getAllWishes

    fun getAllWishes(id: Long): StateFlow<Wish> {
        return wishRepository.getWishById(id)
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), Wish())
    }
    fun addWish(wish: Wish) {
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.addWish(wish)
        }
    }
    fun delete(wish: Wish) {
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.deleteWish(wish)
        }
    }
    fun updateWish(wish: Wish) {
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.updateWish(wish)
        }
    }

    var wishTitle by mutableStateOf("")
    var wishDescription by mutableStateOf("")
    fun onWishTitleChange(newValue: String) { wishTitle = newValue }
    fun onWishDescriptionChange(newValue: String) { wishDescription = newValue }
}




    //    Dispatchers in kt Coroutines are responsible for deciding
//    what thread or threads the coroutine will run on
//    Each type of Dispatchers are designed for
//    different kinds of operations and workload
    //io dispatchers = operations that block the main thread
//            such operations include reading and writing to files , database operations , and network calls
//            often require waiting for data to be read or Written , and during this time the thread is mostly idle
//            so that what it does,
//            so it maintains a shared pool of threads that can grow or shrink according to demand
//            this allows for efficient management of threads when you have many coroutines perform IO operations
//            that are sporadically active.

