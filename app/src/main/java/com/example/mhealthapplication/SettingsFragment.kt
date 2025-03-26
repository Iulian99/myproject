package com.example.mhealthapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class SettingsFragment : Fragment() {
    private lateinit var listView: ListView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view : View = inflater.inflate(R.layout.fragment_settings, container, false)

        listView = view.findViewById(R.id.listView)

        val arrayAdapter: ArrayAdapter<String>
        val users = arrayOf(
            "Python", "Java", "C++", "PHP", "Kotlin", "GoLang", "SQL", "R Language",
            "Android", "Git", "AWS", "Docker", "Azure", "GCP", "JavaScript", "TypeScript",
            "Python", "Java", "C++", "PHP", "Kotlin", "GoLang", "SQL", "R Language",
            "Android", "Git", "AWS", "Docker", "Azure", "GCP", "JavaScript", "TypeScript",
            "Python", "Java", "C++", "PHP", "Kotlin", "GoLang", "SQL", "R Language",
            "Android", "Git", "AWS", "Docker", "Azure", "GCP", "JavaScript", "TypeScript"
        )
        arrayAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, users)

        listView.adapter = arrayAdapter
        return view
    }


}