package com.smartpick.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.smartpick.R
import com.smartpick.databinding.FragmentRekomendasiBinding
import com.smartpick.repository.dummyPhones
import com.smartpick.viewmodel.FavoriteViewModel

class RekomendasiFragment : Fragment() {

    private var _binding: FragmentRekomendasiBinding? = null
    private val binding get() = _binding!!

    private lateinit var favoriteViewModel: FavoriteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRekomendasiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favoriteViewModel = ViewModelProvider(requireActivity())[FavoriteViewModel::class.java]

        val adapter = PhoneAdapter(
            phones = dummyPhones.toMutableList(),
            onFavoriteClick = { phone ->
                favoriteViewModel.add(phone)
            },
            onDetailClick = { phone ->
                val bundle = Bundle().apply {
                    putParcelable("phone", phone)
                }
                findNavController().navigate(R.id.action_rekomendasi_to_detailPhoneFragment, bundle)
            },
            showAsFavorite = false // tampilkan tombol "Favorite" dan "Detail"
        )

        binding.rvRekomendasi.layoutManager = LinearLayoutManager(requireContext())
        binding.rvRekomendasi.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
