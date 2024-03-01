package com.example.desguacespaquito

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import com.example.desguacespaquito.databinding.ActivityRegisterBinding
import com.example.desguacespaquito.db.AppDatabase
import com.example.desguacespaquito.model.Customer

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var  db: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db = Room
            .databaseBuilder(
                this,
                AppDatabase::class.java,
                AppDatabase.DATABASE_NAME2
            )
            .allowMainThreadQueries().build()
        binding.singupButton.setOnClickListener {
            if(binding.usernameTPRegister.text.isEmpty() && binding.passwordTPRegister.text.isEmpty()){
                Toast.makeText(this, "Debe introducir un nombre de usuario o contraseña", Toast.LENGTH_SHORT).show()
            }else{
                val pass1 = binding.passwordTPRegister.text.toString()
                val pass2 = binding.passwordTPRegister2.text.toString()
                if(pass1 == pass2) {
                    val customer = Customer(
                        user = binding.usernameTPRegister.text.toString(),
                        password = binding.passwordTPRegister.text.toString()
                    )
                    Toast.makeText(
                        this,
                        "Registrando a: " + customer.user,
                        Toast.LENGTH_SHORT
                    ).show()
                    db.customerDao().save(customer)
                    val logginActivityIntent = Intent(this, LogginActivity::class.java)
                    startActivity(logginActivityIntent)
                }else{
                    Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}