package com.example.desguacespaquito

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.desguacespaquito.databinding.ActivityGestorBinding

class GestorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGestorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityGestorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar5)

        binding.addButton.setOnClickListener{
            val anadirVehiculoActivityIntent = Intent(this, AnadirVehiculoActivity::class.java)
            startActivity(anadirVehiculoActivityIntent)
        }
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.itemPrincipal->{
                val MainActivityIntent = Intent(this,MainActivity::class.java)
                startActivity(MainActivityIntent)
                true
            }
            R.id.itemLista->{
                val ListadoActivityIntent = Intent(this,ListadoActivity::class.java)
                startActivity(ListadoActivityIntent)
                true
            }
            R.id.itemCompra->{
                val CompraActivityIntent = Intent(this,CompraActivity::class.java)
                startActivity(CompraActivityIntent)
                true
            }
            R.id.itemVende->{
                val VendeActivityIntent = Intent(this,VendeActivity::class.java)
                startActivity(VendeActivityIntent)
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }
}