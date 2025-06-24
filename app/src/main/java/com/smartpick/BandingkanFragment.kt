package com.smartpick.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.smartpick.databinding.FragmentBandingkanBinding
import com.smartpick.viewmodel.CompareViewModel
import com.smartpick.R
import com.smartpick.ui.menu.CompareAdapter

class BandingkanFragment : Fragment() {

    private var _binding: FragmentBandingkanBinding? = null
    private val binding get() = _binding!!
    private val compareViewModel: CompareViewModel by activityViewModels()
    private lateinit var adapter: CompareAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBandingkanBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCompareNow.visibility = View.GONE

        adapter = CompareAdapter(
            phones = mutableListOf(),
            onDeleteClick = { compareViewModel.remove(it) },
            onDetailClick = { phone ->
                val bundle = Bundle().apply {
                    putParcelable("phone", phone)
                }
                findNavController().navigate(R.id.action_bandingkan_to_detailPhoneFragment, bundle)
            },
            onSelectionChanged = {
                val selectedCount = compareViewModel.compareList.value?.count { it.isSelected } ?: 0
                binding.btnCompareNow.visibility =
                    if (selectedCount in 2..3) View.VISIBLE else View.GONE
            }
        )

        binding.rvCompare.layoutManager = GridLayoutManager(requireContext(), 3)
        binding.rvCompare.adapter = adapter

        compareViewModel.compareList.observe(viewLifecycleOwner) { phoneList ->
            adapter.updateData(phoneList.toMutableList())
            // update button visibility on initial load
            val selectedCount = phoneList.count { it.isSelected }
            binding.btnCompareNow.visibility =
                if (selectedCount in 2..3) View.VISIBLE else View.GONE
        }

        binding.btnCompareNow.setOnClickListener {
            val selectedPhones = compareViewModel.compareList.value?.filter { it.isSelected } ?: emptyList()
            if (selectedPhones.size in 2..3) {
                val bundle = Bundle().apply {
                    putParcelableArrayList("selectedPhones", ArrayList(selectedPhones))
                }
                findNavController().navigate(R.id.action_bandingkan_to_compareResultFragment, bundle)
            } else {
                Toast.makeText(requireContext(), "Pilih 2 sampai 3 item untuk dibandingkan", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
