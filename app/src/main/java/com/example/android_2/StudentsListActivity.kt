package com.example.android_2

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.android_2.model.Model
import com.example.android_2.model.Student

class StudentsListActivity : AppCompatActivity() {
    var listView: ListView? = null
    var students: MutableList<Student>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_students_list)

        listView = findViewById(R.id.listView)

        students = Model.shared.students

        listView?.adapter = StudentsAdapter()
    }

    inner class StudentsAdapter(): BaseAdapter() {
        override fun getCount(): Int = students?.size ?: 0

        override fun getItem(position: Int): Any {
            TODO("Not yet implemented")
        }

        override fun getItemId(position: Int): Long {
            TODO("Not yet implemented")
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val inflater = LayoutInflater.from(parent?.context)
            val view = convertView ?: inflater.inflate(R.layout.student_list_row, parent, false)

            val student = students?.get(position)

            val nameTextView: TextView = view.findViewById(R.id.student_row_name_text)
            val idTextView: TextView = view.findViewById(R.id.student_row_id_text)
            val checkbox: CheckBox = view.findViewById(R.id.student_row_checkbox)

            nameTextView.text = student?.name
            idTextView.text = student?.id
            checkbox.isChecked = student?.isChecked ?: false
            checkbox.isEnabled = false

            view.setOnClickListener {
                val intent = Intent(parent?.context, StudentDetailsActivity::class.java).apply {
                    putExtra("studentPosition", position)
                }

                parent?.context?.startActivity(intent)
            }

            return view
        }
    }
}