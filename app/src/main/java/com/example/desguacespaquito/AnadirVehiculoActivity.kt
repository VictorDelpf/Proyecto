package com.example.desguacespaquito

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.desguacespaquito.databinding.ActivityAnadirVehiculoBinding

class AnadirVehiculoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAnadirVehiculoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAnadirVehiculoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar6)

        binding.addButton2.setOnClickListener {
            val car = Car(binding.plateTP.text.toString(), binding.yearTP.text.toString().toInt(), binding.brandTP.text.toString(), binding.modelTP.text.toString(), binding.colorTP.text.toString())
            Toast.makeText(
                this,
                "Vamos a guardar: "+ car.model,
                Toast.LENGTH_SHORT
            ).show()
            finish()
        }
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