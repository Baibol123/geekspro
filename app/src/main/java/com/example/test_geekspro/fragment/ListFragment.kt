package com.example.test_geekspro.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test_geekspro.ItemAdapter
import com.example.test_geekspro.R
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test_geekspro.model.ItemModel

class ListFragment : Fragment(R.layout.fragment_list) {

    private lateinit var recyclerView: RecyclerView
    private val items = listOf(
        ItemModel("https://example.com/image1.jpg", "Item 1", 2020),
        ItemModel("https://example.com/image2.jpg", "Item 2", 2021),
        ItemModel("https://example.com/image3.jpg", "Item 3", 2022)
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerView)

        val adapter = ItemAdapter(items) { item ->
            val action = ListFragmentDirections.actionListFragmentToDetailFragment(item)
            findNavController().navigate(action)

        }
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
    }
}
