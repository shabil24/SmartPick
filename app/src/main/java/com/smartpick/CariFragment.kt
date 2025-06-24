package com.smartpick.ui.menu

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.smartpick.databinding.FragmentCariBinding
import com.smartpick.model.Phone
import com.smartpick.repository.dummyPhones

class CariFragment : Fragment() {
    private var _binding: FragmentCariBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: PhoneAdapter
    private var filteredList: MutableList<Phone> = dummyPhones.toMutableList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCariBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = PhoneAdapter(
            phones = filteredList,
            onFavoriteClick = {},
            onDetailClick = {}
        )

        binding.rvCari.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCari.adapter = adapter

        setupFilters()

        // Tombol pencarian rekomendasi
        binding.btnCariRekomendasi.setOnClickListener {
            binding.rvCari.visibility = View.VISIBLE
        }
    }


    private fun setupFilters() {
        val brands = dummyPhones.map { it.brand }.distinct()
        val kebutuhanList = dummyPhones.flatMap { it.kebutuhan }.distinct()
        val hargaOptions = listOf("Semua", "< 5jt", "5-10jt", "> 10jt")

        val brandAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, listOf("Semua") + brands)
        val kebutuhanAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, listOf("Semua") + kebutuhanList)
        val hargaAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, hargaOptions)

        brandAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        kebutuhanAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        hargaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spinnerBrand.adapter = brandAdapter
        binding.spinnerKebutuhan.adapter = kebutuhanAdapter
        binding.spinnerHarga.adapter = hargaAdapter

        val filterAction = {
            val query = binding.etSearch.text.toString().lowercase()
            val selectedBrand = binding.spinnerBrand.selectedItem.toString()
            val selectedKebutuhan = binding.spinnerKebutuhan.selectedItem.toString()
            val selectedHarga = binding.spinnerHarga.selectedItem.toString()

            filteredList = dummyPhones.filter { phone ->
                val hargaInt = parseHarga(phone.harga)

                // Cek apakah query cocok dengan nama, brand, kebutuhan, atau harga
                val cocokQuery = query.isBlank() || listOf(
                    phone.merek,
                    phone.brand,
                    phone.harga,
                    phone.kebutuhan.joinToString(" ")
                ).any { it.lowercase().contains(query) }

                val cocokBrand = selectedBrand == "Semua" || phone.brand == selectedBrand
                val cocokKebutuhan = selectedKebutuhan == "Semua" || phone.kebutuhan.contains(selectedKebutuhan)
                val cocokHarga = when (selectedHarga) {
                    "< 5jt" -> hargaInt < 5_000_000
                    "5-10jt" -> hargaInt in 5_000_000..10_000_000
                    "> 10jt" -> hargaInt > 10_000_000
                    else -> true
                }

                cocokQuery && cocokBrand && cocokKebutuhan && cocokHarga
            }.toMutableList()

            adapter.updateData(filteredList)
        }


        binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) = filterAction()
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        binding.spinnerBrand.onItemSelectedListener = simpleSpinnerListener(filterAction)
        binding.spinnerKebutuhan.onItemSelectedListener = simpleSpinnerListener(filterAction)
        binding.spinnerHarga.onItemSelectedListener = simpleSpinnerListener(filterAction)
    }

    private fun simpleSpinnerListener(action: () -> Unit) = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) = action()
        override fun onNothingSelected(parent: AdapterView<*>) {}
    }

    private fun parseHarga(harga: String): Int {
        return harga.replace(Regex("[^0-9]"), "").toIntOrNull() ?: 0
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
