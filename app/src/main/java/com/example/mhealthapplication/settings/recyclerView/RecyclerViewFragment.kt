package com.example.mhealthapplication.settings.recyclerView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mhealthapplication.R

class RecyclerViewFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view : View =  inflater.inflate(R.layout.fragment_recycler_view, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)

        // Sample data
        val examList: MutableList<Item> = ArrayList()
        examList.add(Item("Science Exam"))
        examList.add(Item("History Exam"))
        examList.add(Item("English Exam"))
        examList.add(Item("Science Exam"))
        examList.add(Item("History Exam"))
        examList.add(Item("English Exam"))
        examList.add(Item("Science Exam"))
        examList.add(Item("History Exam"))
        examList.add(Item("English Exam"))
        examList.add(Item("Science Exam"))
        examList.add(Item("History Exam"))
        examList.add(Item("English Exam"))
        examList.add(Item("English Exam"))
        examList.add(Item("Science Exam"))
        examList.add(Item("History Exam"))
        examList.add(Item("English Exam"))
        examList.add(Item("Science Exam"))
        examList.add(Item("History Exam"))
        examList.add(Item("English Exam"))
        examList.add(Item("Science Exam"))
        examList.add(Item("History Exam"))
        examList.add(Item("English Exam"))
        examList.add(Item("English Exam"))
        examList.add(Item("Science Exam"))
        examList.add(Item("History Exam"))
        examList.add(Item("English Exam"))
        examList.add(Item("Science Exam"))
        examList.add(Item("History Exam"))
        examList.add(Item("English Exam"))
        examList.add(Item("Science Exam"))
        examList.add(Item("History Exam"))
        examList.add(Item("English Exam"))

        // Set LayoutManager
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Set Adapter
        val adapter = MyAdapter(examList)
        recyclerView.adapter = adapter
        return view
    }


}