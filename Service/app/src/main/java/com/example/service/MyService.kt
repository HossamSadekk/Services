package com.example.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

//  NOTE :: if u do a large calculations us should use worker thread

class MyService: Service() {

    val TAG = "MyService"

    init {
        Log.d(TAG,"Service is running.......")
    }

    override fun onBind(p0: Intent?): IBinder? = null

    // this function called when startService() is invoked there is onCreate() is invoked before it.
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {


        val dataString = intent?.getStringExtra("data")
        dataString?.let {
            Log.d(TAG,dataString)
        }
        // example for code will freeze ui if i don't use thread
        Thread{while (true){} }.start()
        return START_STICKY
    }

}