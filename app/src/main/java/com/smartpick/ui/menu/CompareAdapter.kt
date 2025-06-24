package com.smartpick.ui.menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smartpick.databinding.ItemCompareBinding
import com.smartpick.model.Phone

class CompareAdapter(
    private val phones: MutableList<Phone>,
    private val onDeleteClick: (Phone) -> Unit,
    private val onDetailClick: (Phone) -> Unit,
    private val onSelectionChanged: (Int) -> Unit // jumlah item terpilih
) : RecyclerView.Adapter<CompareAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemCompareBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCompareBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = phones.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val phone = phones[position]
        with(holder.binding) {
            ivPhone.setImageResource(phone.imageResId)
            tvMerek.text = phone.merek

            // Checkbox untuk memilih item yang akan dibandingkan
            checkboxSelect.apply {
                visibility = View.VISIBLE
                isChecked = phone.isSelected
                setOnCheckedChangeListener(null) // Reset listener dulu agar tidak trigger saat bind ulang
                isChecked = phone.isSelected
                setOnCheckedChangeListener { _, isChecked ->
                    phone.isSelected = isChecked
                    onSelectionChanged(phones.count { it.isSelected })
                }
            }

            // Tombol Hapus & Detail
            btnHapus.setOnClickListener { onDeleteClick(phone) }
            btnDetail.setOnClickListener { onDetailClick(phone) }
        }
    }

    fun updateData(newPhones: List<Phone>) {
        phones.clear()
        phones.addAll(newPhones)
        notifyDataSetChanged()
    }
}
