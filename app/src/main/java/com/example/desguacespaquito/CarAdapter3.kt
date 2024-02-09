package com.example.desguacespaquito

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.desguacespaquito.databinding.Car3LayoutBinding
import com.example.desguacespaquito.db.AppDatabase
import com.example.desguacespaquito.model.Car

class CarAdapter3(var cars: List<Car>, val context: Context, val db: AppDatabase):
    RecyclerView.Adapter<CarAdapter3.ItemViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarAdapter3.ItemViewHolder {
        return CarAdapter3.ItemViewHolder(
            layoutInflater.inflate(R.layout.car3_layout, null)
        )
    }

    override fun onBindViewHolder(holder: CarAdapter3.ItemViewHolder, position: Int) {
        val car = cars[position]
        val binding = Car3LayoutBinding.bind(holder.itemView)

        binding.carBrandTV.text = car.brand

        binding.carModelTV.text = car.model

        binding.carPlateTV.text = car.numberPlate

        binding.carYearTV.text = car.year.toString()

        binding.venderButton.setOnClickListener {
            Toast.makeText(context, "Vendiendo la unidad ${car.model}", Toast.LENGTH_LONG).show()
        }


    }

    override fun getItemCount(): Int {
        return cars.size
    }
}