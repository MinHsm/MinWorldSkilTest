package com.min.b_module_test.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.google.android.material.button.MaterialButton
import com.min.b_module_test.R
import com.min.b_module_test.enity.OneCar

/**
 *Created by ming on 2024/7/7.
 */
class OneCarItemAdapter(private val cars: List<OneCar>) :
    RecyclerView.Adapter<OneCarItemAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val carName: TextView = itemView.findViewById(R.id.one_tv_car)
        val rating: TextView = itemView.findViewById(R.id.one_tv_rating)
        val yearType: TextView = itemView.findViewById(R.id.one_tv_content)
        val seats: TextView = itemView.findViewById(R.id.one_tv_seat)
        val doors: TextView = itemView.findViewById(R.id.one_tv_gate)
        val bags: TextView = itemView.findViewById(R.id.one_tv_bag)
        val carImage: ImageView = itemView.findViewById(R.id.one_iv_car)
        val price: TextView = itemView.findViewById(R.id.one_tv_price)
        val preDay: TextView = itemView.findViewById(R.id.one_tv_day)
        val bookButton: MaterialButton = itemView.findViewById(R.id.one_btn_book)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_car_one, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount() = cars.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val car = cars[position]
        holder.carName.text = car.name
        holder.rating.text = car.rating.toString()
        holder.yearType.text = car.yearType
        holder.seats.text = car.seats.toString()
        holder.doors.text = car.doors.toString()
        holder.bags.text = car.bags.toString()
        holder.carImage.setImageResource(car.imageResId)
        holder.price.text = car.price
        holder.preDay.text = "per day"
        holder.bookButton
    }

}