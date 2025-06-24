package com.smartpick.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.smartpick.databinding.FragmentFavoriteBinding
import com.smartpick.viewmodel.FavoriteViewModel
import com.smartpick.viewmodel.CompareViewModel

class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    private lateinit var favoriteViewModel: FavoriteViewModel
    private lateinit var adapter: PhoneAdapter

    private val compareViewModel: CompareViewModel by lazy {
        ViewModelProvider(requireActivity())[CompareViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favoriteViewModel = ViewModelProvider(requireActivity())[FavoriteViewModel::class.java]

        adapter = PhoneAdapter(
            phones = favoriteViewModel.favoriteList.value?.toMutableList() ?: mutableListOf(),
            onFavoriteClick = { phone ->
                compareViewModel.add(phone)
            },
            onDetailClick = { phone ->
                favoriteViewModel.remove(phone)
            },
            showAsFavorite = true
        )

        binding.rvFavorite.layoutManager = LinearLayoutManager(requireContext())
        binding.rvFavorite.adapter = adapter

        favoriteViewModel.favoriteList.observe(viewLifecycleOwner) { updatedList ->
            adapter.updateData(updatedList)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
