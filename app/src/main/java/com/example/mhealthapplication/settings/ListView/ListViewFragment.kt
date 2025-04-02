package com.example.mhealthapplication.settings.ListView

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import com.example.mhealthapplication.R

class ListViewFragment : Fragment() {

    private lateinit var listView: ListView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view : View = inflater.inflate(R.layout.fragment_list_view, container, false)

        listView = view.findViewById(R.id.list_view)

        val arrayAdapter: ArrayAdapter<String>
        val users = arrayOf(
            "Python", "Java", "C++", "PHP", "Kotlin", "GoLang", "SQL", "R Language",
            "Android", "Git", "AWS", "Docker", "Azure", "GCP", "JavaScript", "TypeScript",
            "Python", "Java", "C++", "PHP", "Kotlin", "GoLang", "SQL", "R Language",
            "Android", "Git", "AWS", "Docker", "Azure", "GCP", "JavaScript", "TypeScript",
            "Python", "Java", "C++", "PHP", "Kotlin", "GoLang", "SQL", "R Language",
            "Android", "Git", "AWS", "Docker", "Azure", "GCP", "JavaScript", "TypeScript"
        )
//        arrayAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, users)
        arrayAdapter = object : ArrayAdapter<String>(requireContext(), R.layout.item_list, R.id.text_item, users) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = super.getView(position, convertView, parent)
                val textView = view.findViewById<TextView>(R.id.text_item)
                textView.text = users[position]
                return view
            }
        }
        listView.adapter = arrayAdapter

        return view
    }

}