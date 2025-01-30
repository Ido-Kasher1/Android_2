package com.example.android_2

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android_2.model.Model

class EditStudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edit_student)

        // Get the student position passed from the previous activity
        val position = intent.getIntExtra("studentPosition", 0)

        val main: ConstraintLayout? = findViewById(R.id.constraintLayout)

        // Get references to the TextViews, CheckBox and Buttons
        val nameTextView: TextView? = main?.findViewById(R.id.nameTextView)
        val idTextView: TextView? = main?.findViewById(R.id.idTextView)
        val phoneTextView: TextView? = main?.findViewById(R.id.phoneTextView)
        val addressTextView: TextView? = main?.findViewById(R.id.addressTextView)
        val checkbox: CheckBox? = main?.findViewById(R.id.checkedCheckBox)

        // Get the student from the Model
        val student = Model.shared.students[position]

        // Set initial values in the UI based on the student's information
        nameTextView?.text = student.name
        idTextView?.text = student.id.toString()
        phoneTextView?.text = student.phone
        addressTextView?.text = student.address
        checkbox?.isChecked = student.isChecked
        checkbox?.isEnabled = false // Disable the checkbox (it cannot be edited)

        // Get references to the buttons
        val saveButton = findViewById<Button>(R.id.saveButton)
        val deleteButton = findViewById<Button>(R.id.deleteButton)
        val cancelButton = findViewById<Button>(R.id.cancelButton)

        saveButton.setOnClickListener {
            student.name = nameTextView?.text.toString()
            student.phone = phoneTextView?.text.toString()
            student.address = addressTextView?.text.toString()
            student.isChecked = checkbox?.isChecked == true

            // Show a confirmation message
            Toast.makeText(this, "Student details saved", Toast.LENGTH_SHORT).show()

            // Return to the previous activity
            finish()
        }

        // Handle delete button click
        deleteButton.setOnClickListener {
            // Remove the student from the list
            Model.shared.students.removeAt(position)

            // Show a confirmation message
            Toast.makeText(this, "Student deleted", Toast.LENGTH_SHORT).show()

            // Return to the previous activity
            finish()
        }

        // Handle cancel button click
        cancelButton.setOnClickListener {
            // Simply return to the previous activity without saving or deleting
            finish()
        }

           ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.constraintLayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
