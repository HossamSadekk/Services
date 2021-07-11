package com.example.foreground

import android.app.Application
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class app: Application() {
companion object{    var CHANNEL_ID = "serviceChannel"
}

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            var serviceChannel = NotificationChannel(CHANNEL_ID,"Service Channel",NotificationManager.IMPORTANCE_HIGH)
            var manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(serviceChannel)
        }
    }
}