package com.smartpick.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.smartpick.databinding.FragmentDashboardBinding
import androidx.navigation.fragment.findNavController
import com.smartpick.R

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("DashboardFragment", "onCreateView dipanggil")
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.edtCari.setOnClickListener {
            findNavController().navigate(R.id.action_dashboard_to_cari)
        }
        binding.edtFavorite.setOnClickListener {
            findNavController().navigate(R.id.action_dashboard_to_favorite)
        }
        binding.edtBanding.setOnClickListener {
            findNavController().navigate(R.id.action_dashboard_to_bandingkan)
        }
        binding.edtRekomendasi.setOnClickListener {
            findNavController().navigate(R.id.action_dashboard_to_rekomendasi)
        }

    }

    private fun navigateToFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment_activity_main, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
