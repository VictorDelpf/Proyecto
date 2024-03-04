package com.example.desguacespaquito

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.desguacespaquito.databinding.ActivityVendeBinding
import com.example.desguacespaquito.db.AppDatabase

class VendeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVendeBinding
    private lateinit var db: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityVendeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar4)

        db = Room
            .databaseBuilder(
                this,
                AppDatabase::class.java,
                AppDatabase.DATABASE_NAME
            )
            .allowMainThreadQueries().build()

        binding.carsRecyclerView.layoutManager =
            GridLayoutManager(this, 1, RecyclerView.VERTICAL, false)

        binding.carsRecyclerView.adapter = CarAdapter3(
            db.carDao().listByCostumer(), this, db
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