package com.example.desguacespaquito

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.room.Room
import com.example.desguacespaquito.databinding.ActivityAnadirVehiculoBinding
import com.example.desguacespaquito.db.AppDatabase
import com.example.desguacespaquito.model.Car

class AnadirVehiculoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAnadirVehiculoBinding
    private lateinit var db: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAnadirVehiculoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar6)
        db = Room
            .databaseBuilder(
                this,
                AppDatabase::class.java,
                AppDatabase.DATABASE_NAME
            )
            .allowMainThreadQueries().build()
/*        binding.addButton2.setOnClickListener {
            val car = Car(binding.plateTP.text.toString(), binding.yearTP.text.toString().toInt(), binding.brandTP.text.toString(), binding.modelTP.text.toString(), binding.colorTP.text.toString(), binding.)
            Toast.makeText(
                this,
                "Vamos a guardar: "+ car.model,
                Toast.LENGTH_SHORT
            ).show()
            db.carDao().save(car)
            finish()
        }*/
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