package com.smartpick.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.smartpick.databinding.FragmentDetailPhoneBinding
import com.smartpick.model.Phone
import com.smartpick.viewmodel.CompareViewModel
import com.smartpick.viewmodel.FavoriteViewModel

class DetailPhoneFragment : Fragment() {

    private var _binding: FragmentDetailPhoneBinding? = null
    private val binding get() = _binding!!

    private val compareViewModel: CompareViewModel by activityViewModels()
    private val favoriteViewModel: FavoriteViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailPhoneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val phone = arguments?.getParcelable<Phone>("phone")

        phone?.let {
            binding.ivPhone.setImageResource(it.imageResId)
            binding.tvMerek.text = it.merek
            binding.tvBrand.text = it.brand
            binding.tvHarga.text = it.harga
            binding.tvRating.text = "⭐".repeat(it.rating) + "★".repeat(5 - it.rating)
            binding.tvDeskripsi.text = it.deskripsi
            binding.tvSpesifikasi.text = it.spesifikasi
            binding.tvKebutuhan.text = it.kebutuhan.joinToString(", ")
            binding.tvStatus.text = if (it.tersedia) "Tersedia" else "Tidak Tersedia"

            // Tombol Bandingkan
            binding.btnBandingkan.setOnClickListener {
                compareViewModel.add(phone)
                Toast.makeText(requireContext(), "Ditambahkan ke Bandingkan", Toast.LENGTH_SHORT).show()
            }

            // Tombol Favorite
            binding.btnFavorite.setOnClickListener {
                favoriteViewModel.add(phone)
                Toast.makeText(requireContext(), "Ditambahkan ke Favorite", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
