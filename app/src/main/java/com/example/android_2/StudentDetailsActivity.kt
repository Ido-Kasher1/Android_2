package com.example.android_2

import android.os.Bundle
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android_2.model.Model

class StudentDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        val position = intent.getIntExtra("studentPosition", 0)

        val main: ConstraintLayout? = findViewById(R.id.constraintLayout)

        val nameTextView: TextView? = main?.findViewById(R.id.student_details_name)
        val idTextView: TextView? = main?.findViewById(R.id.student_details_id)
        val phoneTextView: TextView? = main?.findViewById(R.id.student_details_phone)
        val addressTextView: TextView? = main?.findViewById(R.id.student_details_address)
        val checkbox: CheckBox? = main?.findViewById(R.id.student_details_checkbox)

        val student = Model.shared.students[position]

        nameTextView?.text = "name ${student.name}"
        idTextView?.text = "id: ${student.id}"
        phoneTextView?.text = "phone: ${student.phone}"
        addressTextView?.text = "address: ${student.address}"
        checkbox?.isChecked = student.isChecked
        checkbox?.isEnabled = false

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.constraintLayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}