package com.smartpick.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.smartpick.databinding.FragmentCompareResultBinding
import com.smartpick.model.Phone

class CompareResultFragment : Fragment() {

    private var _binding: FragmentCompareResultBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: CompareResultAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCompareResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val phones = arguments?.getParcelableArrayList<Phone>("selectedPhones")

        if (phones.isNullOrEmpty() || phones.size !in 2..3) {
            Toast.makeText(requireContext(), "Pilih 2 sampai 3 item untuk dibandingkan", Toast.LENGTH_SHORT).show()
            activity?.onBackPressedDispatcher?.onBackPressed()
            return
        }

        adapter = CompareResultAdapter(phones)
        binding.rvCompareResult.layoutManager = GridLayoutManager(requireContext(), phones.size)
        binding.rvCompareResult.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
