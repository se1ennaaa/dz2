package com.example.dz2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dz2.databinding.ActivityMainBinding
import com.example.dz2.ui.first.FirstFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().replace(R.id.container,FirstFragment()).commit()
    }
}