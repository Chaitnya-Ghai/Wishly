package com.example.wishly

import android.app.Application

class MyApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}