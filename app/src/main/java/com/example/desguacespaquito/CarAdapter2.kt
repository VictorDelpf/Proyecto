package com.example.desguacespaquito

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.desguacespaquito.databinding.Car2LayoutBinding
import com.example.desguacespaquito.databinding.CarLayoutBinding
import com.example.desguacespaquito.db.AppDatabase
import com.example.desguacespaquito.model.Car

class CarAdapter2(var cars: List<Car>, val context: Context, val db: AppDatabase):
    RecyclerView.Adapter<CarAdapter2.ItemViewHolder>(){

    private val layoutInflater = LayoutInflater.from(context)
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarAdapter2.ItemViewHolder {
        return CarAdapter2.ItemViewHolder(
            layoutInflater.inflate(R.layout.car2_layout, null)
        )
    }

    override fun getItemCount(): Int {
        return cars.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val car = cars[position]
        val binding = Car2LayoutBinding.bind(holder.itemView)

        binding.carBrandTV.text = car.brand

        binding.carModelTV.text = car.model

        binding.carPlateTV.text = car.numberPlate

        binding.carYearTV.text = car.year.toString()

        binding.compraButton.setOnClickListener {
            Toast.makeText(context, "Comprando la unidad ${car.model}", Toast.LENGTH_LONG).show()
        }
    }


}