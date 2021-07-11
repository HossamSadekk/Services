package com.example.foreground

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var editText: EditText
    lateinit var startService: Button
    lateinit var stopService: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText = findViewById(R.id.et)
        startService = findViewById(R.id.start)
        stopService = findViewById(R.id.stop)

        startService.setOnClickListener {
            var string = editText.text.toString()
            Intent(this,ExampleService::class.java).also {
                it.putExtra("data",string)
                startService(it)
            }
        }

        stopService.setOnClickListener {
            Intent(this,ExampleService::class.java).also {
                stopService(it)
            }
        }
    }
}