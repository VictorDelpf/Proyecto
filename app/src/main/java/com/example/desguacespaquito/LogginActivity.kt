package com.example.desguacespaquito

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import com.example.desguacespaquito.databinding.ActivityLogginBinding
import com.example.desguacespaquito.db.AppDatabase
import com.example.desguacespaquito.model.Customer

class LogginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLogginBinding
    private lateinit var  db: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db = Room
            .databaseBuilder(
                this,
                AppDatabase::class.java,
                AppDatabase.DATABASE_NAME2
            )
            .allowMainThreadQueries().build()
        binding.loginButton.setOnClickListener {
            if (binding.usernamePT.text.isEmpty() && binding.passwordTP.text.isEmpty()) {
                Toast.makeText(
                    this,
                    "Debe introducir un nombre de usuario o contraseña",
                    Toast.LENGTH_SHORT
                ).show()
            }else{
                val user = binding.usernamePT.text.toString()
                val pass1 = binding.passwordTP.text.toString()
                val login = db.customerDao().inicio(user, pass1)
                if(login == 1){
                    val mainActivityIntent = Intent(this, MainActivity::class.java)
                    startActivity(mainActivityIntent)
                }else{
                    Toast.makeText(
                        this,
                        "No se ha encontrado ese usuario o esa contraseña",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}