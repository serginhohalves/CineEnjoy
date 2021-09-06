package com.projeto1.movieenjoy.features

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.projeto1.movieenjoy.R
import com.projeto1.movieenjoy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}