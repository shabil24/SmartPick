package com.smartpick.ui.menu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smartpick.databinding.ItemPhoneBinding
import com.smartpick.model.Phone

class PhoneAdapter(
    private val phones: MutableList<Phone>, // <- ubah jadi MutableList
    private val onFavoriteClick: (Phone) -> Unit,
    private val onDetailClick: (Phone) -> Unit,
    private val showAsFavorite: Boolean = false
) : RecyclerView.Adapter<PhoneAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemPhoneBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPhoneBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = phones.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val phone = phones[position]
        with(holder.binding) {
            ivPhone.setImageResource(phone.imageResId)
            tvMerek.text = phone.merek
            tvHarga.text = phone.harga
            tvStatus.text = if (phone.tersedia) "Tersedia" else "Tidak Tersedia"

            if (showAsFavorite) {
                btnFavorite.text = "Bandingkan"
                btnDetail.text = "Hapus"
                btnFavorite.setOnClickListener { onFavoriteClick(phone) }
                btnDetail.setOnClickListener { onDetailClick(phone) }
            } else {
                btnFavorite.text = "Favorite"
                btnDetail.text = "Detail"
                btnFavorite.setOnClickListener { onFavoriteClick(phone) }
                btnDetail.setOnClickListener { onDetailClick(phone) }
            }
        }
    }

    // ✅ Tambahkan ini di akhir class
    fun updateData(newPhones: List<Phone>) {
        phones.clear()
        phones.addAll(newPhones)
        notifyDataSetChanged()
    }
}
