package com.example.desguacespaquito

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.example.desguacespaquito.databinding.ActivityCompraBinding
import com.example.desguacespaquito.databinding.ActivityListadoBinding

class CompraActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCompraBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCompraBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar3)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}