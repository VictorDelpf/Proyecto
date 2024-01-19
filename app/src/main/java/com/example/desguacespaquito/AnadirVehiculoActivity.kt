package com.example.desguacespaquito

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.desguacespaquito.databinding.ActivityAnadirVehiculoBinding

class AnadirVehiculoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAnadirVehiculoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAnadirVehiculoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar6)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_back,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.itemBack -> {
                val gestorActivityIntent = Intent(this, GestorActivity::class.java)
                startActivity(gestorActivityIntent)
                true
            }

            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }
}