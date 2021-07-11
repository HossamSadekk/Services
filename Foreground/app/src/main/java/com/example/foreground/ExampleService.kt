package com.example.foreground

import android.app.Notification
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.example.foreground.app.Companion.CHANNEL_ID

class ExampleService: Service() {
    override fun onBind(p0: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        var input = intent?.getStringExtra("data")

        var intent = Intent(this,MainActivity::class.java)
        var pendingIntent = PendingIntent.getActivity(this,0,intent,0)

        var notification = NotificationCompat.Builder(this,CHANNEL_ID)
            .setContentTitle("Foreground service")
            .setContentText(input)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentIntent(pendingIntent)
            .build()

        startForeground(1,notification)

        return START_NOT_STICKY
    }
}