package com.example.desguacespaquito

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.desguacespaquito.databinding.ActivityCompraBinding
import com.example.desguacespaquito.databinding.ActivityListadoBinding
import com.example.desguacespaquito.db.AppDatabase

class CompraActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCompraBinding
    private lateinit var db: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCompraBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar3)

        db = Room
            .databaseBuilder(
                this,
                AppDatabase::class.java,
                AppDatabase.DATABASE_NAME
            )
            .allowMainThreadQueries().build()

        binding.carsRecyclerView.layoutManager =
            GridLayoutManager(this, 1, RecyclerView.VERTICAL, false)

        binding.carsRecyclerView.adapter = CarAdapter2(
            db.carDao().list(), this, db
        )
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
            R.id.itemGestor->{
                val GestorActivityIntent = Intent(this,GestorActivity::class.java)
                startActivity(GestorActivityIntent)
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