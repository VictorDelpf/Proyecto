package com.example.desguacespaquito

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.desguacespaquito.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val extras = intent.extras

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val userId = intent.extras?.getInt("usuario")!!

        return when(item.itemId){
            R.id.itemLista->{
                 val listadoActivityIntent = Intent(this,ListadoActivity::class.java)
                listadoActivityIntent.putExtra("usuario", userId)
                 startActivity(listadoActivityIntent)
                true
             }
            R.id.itemGestor->{
                val gestorActivityIntent = Intent(this,GestorActivity::class.java)
                gestorActivityIntent.putExtra("usuario", userId)
                startActivity(gestorActivityIntent)
                true
            }
            R.id.itemCompra->{
                val compraActivityIntent = Intent(this,CompraActivity::class.java)
                compraActivityIntent.putExtra("usuario", userId)
                startActivity(compraActivityIntent)
                true
            }
            R.id.itemVende->{
                val vendeActivityIntent = Intent(this,VendeActivity::class.java)
                vendeActivityIntent.putExtra("usuario", userId)
                startActivity(vendeActivityIntent)
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }
}