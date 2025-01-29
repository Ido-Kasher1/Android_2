package com.example.android_2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class StudentsListActivity : AppCompatActivity() {
    var listView: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_students_list)

        listView = findViewById(R.id.listView)

        val students = arrayOf("Alice", "Bob", "Charlie", "David", "Emma")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, students)

        listView?.adapter = StudentsAdapter()
    }

    class StudentsAdapter(): BaseAdapter() {
        override fun getCount(): Int = 10

        override fun getItem(position: Int): Any {
            TODO("Not yet implemented")
        }

        override fun getItemId(position: Int): Long {
            TODO("Not yet implemented")
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val inflater = LayoutInflater.from(parent?.context)
            val view = convertView ?: inflater.inflate(R.layout.student_list_row, parent, false)

            val nameTextView: TextView = view.findViewById(R.id.student_row_name_text)
            val idTextView: TextView = view.findViewById(R.id.student_row_id_text)
            val checkbox: CheckBox = view.findViewById(R.id.student_row_checkbox)

            nameTextView.text = "Michael Berzeboosky"
            idTextView.text = "1234"

            return view
        }
    }
}