package com.example.test_geekspro.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.test_geekspro.R
import com.example.test_geekspro.databinding.FragmentDatailBinding

class DetailFragment : Fragment(R.layout.fragment_datail) {

    private var _binding: FragmentDatailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDatailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val item = arguments?.let { DetailFragmentArgs.fromBundle(it).item }

        binding.detailNameTextView.text = item?.name
        binding.detailYearTextView.text = item?.year.toString()
        Glide.with(this)
            .load(item?.imageUrl)
            .into(binding.detailImageView)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
