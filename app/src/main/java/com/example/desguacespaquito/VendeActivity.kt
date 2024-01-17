package com.example.desguacespaquito

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.example.desguacespaquito.databinding.ActivityListadoBinding
import com.example.desguacespaquito.databinding.ActivityVendeBinding

class VendeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVendeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityVendeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar4)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}