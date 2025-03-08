package com.example.wishly.dataClasses

data class Wish(
    val id :Long?=0L,
    val title: String?="",
    val description: String?="",
)
object DummyList{
    val Wishlist = listOf(
        Wish(title = "Wish 1", description = "Description 1"),
        Wish(title = "Wish 2", description = "Description 2"),
        Wish(title = "Wish 3", description = "Description 3"),
    )
}
