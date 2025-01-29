package com.example.android_2

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import com.example.android_2.model.Student

class NewStudentActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_student) // Ensure this is the correct layout file

        // Optionally initialize your views
        val saveButton: Button = findViewById(R.id.saveButton)
        val cancelButton: Button = findViewById(R.id.cancelButton)

        saveButton.setOnClickListener { view ->
            onSaveClicked(view)
        }

        cancelButton.setOnClickListener { view ->
            onCancelClick(view)
        }
    }

    private fun onSaveClicked(view: View) {
        // Get input fields from the layout
        val idTextView: EditText = findViewById(R.id.idTextView)
        val nameTextView: EditText = findViewById(R.id.nameTextView)

        val student = Student(
            id = idTextView.text.toString(),
            name = nameTextView.text.toString(),
            avatarUrl = "",
            isChecked = false
        )

        // Assume progressBar is a part of the layout and can be made visible during save
        val progressBar: ProgressBar = findViewById(R.id.progressBar)
        progressBar.visibility = View.VISIBLE
    }

    private fun onCancelClick(view: View) {
        finish() // Close activity without saving
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menu.clear()
        return super.onCreateOptionsMenu(menu)
    }
}
