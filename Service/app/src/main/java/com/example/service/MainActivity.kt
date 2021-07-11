package com.example.service

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.service.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.startBtn.setOnClickListener {
            Intent(this,MyService::class.java).also {
                startService(it)
                binding.text.text = "Service is running now!"
            }
        }

        binding.stopBtn.setOnClickListener {
            Intent(this,MyService::class.java).also {
                stopService(it)
                binding.text.text = "Service Stopped"
            }
        }

        binding.sendBtn.setOnClickListener {
            Intent(this,MyService::class.java).also {
                val dataString = binding.editText.text.toString()
                it.putExtra("data",dataString)
                startService(it)
                binding.text.text = "Service is running now!"
            }
        }

    }
}