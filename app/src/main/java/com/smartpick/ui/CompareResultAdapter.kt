package com.smartpick.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smartpick.databinding.ItemCompareResultBinding
import com.smartpick.model.Phone

class CompareResultAdapter(private var phones: List<Phone>) :
    RecyclerView.Adapter<CompareResultAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemCompareResultBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCompareResultBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = phones.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val phone = phones[position]
        with(holder.binding) {
            ivPhoneImage.setImageResource(phone.imageResId)
            tvPhoneName.text = phone.merek
            tvPhonePrice.text = phone.harga
            tvSpesifikasi.text = "Spesifikasi:\n${phone.spesifikasi}"
        }
    }

    fun updateData(newData: List<Phone>) {
        phones = newData
        notifyDataSetChanged()
    }
}
