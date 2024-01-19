package com.example.desguacespaquito

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }
}