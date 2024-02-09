package com.example.desguacespaquito

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.desguacespaquito.databinding.CarLayoutBinding
import com.example.desguacespaquito.db.AppDatabase
import com.example.desguacespaquito.model.Car

class CarAdapter(var cars: List<Car>, val context: Context, val db: AppDatabase):
 RecyclerView.Adapter<CarAdapter.ItemViewHolder>() {

  private val layoutInflater = LayoutInflater.from(context)

  class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
   return ItemViewHolder(
    layoutInflater.inflate(R.layout.car_layout, null)
   )
 }

 override fun getItemCount(): Int {
  return cars.size
 }

 override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
  val car = cars[position]
  val binding = CarLayoutBinding.bind(holder.itemView)

  binding.carBrandTV.text = car.brand

  binding.carModelTV.text = car.model

  binding.carPlateTV.text = car.numberPlate


  binding.deleteCarButton.setOnClickListener{
   Toast.makeText(context, "Eliminando el coche ${car.model}", Toast.LENGTH_LONG).show()
   db.carDao().delete(car.numberPlate)
   cars= db.carDao().list()
   notifyDataSetChanged()
  }
  binding.editCarButton.setOnClickListener {
   Toast.makeText(context, "Editando el coche ${car.model}", Toast.LENGTH_LONG).show()

  }
 }

}