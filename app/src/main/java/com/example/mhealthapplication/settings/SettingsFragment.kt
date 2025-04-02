package com.example.mhealthapplication.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.mhealthapplication.R
import com.example.mhealthapplication.settings.Camera.CameraFragment
import com.example.mhealthapplication.settings.ListView.ListViewFragment
import com.example.mhealthapplication.settings.recyclerView.RecyclerViewFragment

class SettingsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        val listView: ListView = view.findViewById(R.id.listView)

        val options = listOf("ListView", "RecyclerView","OpenCamera")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, options)

        listView.adapter = adapter
        listView.setOnItemClickListener { parent, view, position, id ->
            when (options[position]) {
                "ListView" -> openFragment(ListViewFragment())
                "RecyclerView" -> openFragment(RecyclerViewFragment())
                "OpenCamera" -> openFragment(CameraFragment())
            }
        }

        return view
    }

    private fun openFragment(fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, fragment)
            .addToBackStack(null)
            .commit()
    }
}