package com.example.desguacespaquito

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.example.desguacespaquito.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: Menu): Boolean {
        return when(item.itemId){
            R.id.itemLista->{
                 val MainActivityIntent = Intent(this,MainActivity::class.java)
                 startActivity(MainActivityIntent)
                true
             }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }
}