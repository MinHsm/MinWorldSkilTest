package com.min.b_module_test.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.min.b_module_test.R
import com.min.b_module_test.enity.TwoCar

/**
 *Created by ming on 2024/7/8.
 */
class TwoCarItemAdapter(private val carItemList: List<TwoCar>) :
    RecyclerView.Adapter<TwoCarItemAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val carImage: ImageView = itemView.findViewById(R.id.two_iv_car)
        val userImage: ImageView = itemView.findViewById(R.id.two_iv_head)
        val priceButton: MaterialButton = itemView.findViewById(R.id.two_btn_day)
        val carName: TextView = itemView.findViewById(R.id.two_tv_carname)
        val location: TextView = itemView.findViewById(R.id.two_tv_content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_car_two, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount() = carItemList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = carItemList[position]

        holder.carImage.setImageResource(currentItem.carImageResId)
        holder.userImage.setImageResource(currentItem.userImageResId)
        holder.priceButton.text = currentItem.price
        holder.location.text = currentItem.location
        holder.carName.text = currentItem.carName
    }
}