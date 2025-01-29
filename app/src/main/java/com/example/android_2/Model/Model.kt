package com.example.android_2.Model

import android.graphics.Bitmap
import android.os.Looper
import androidx.core.os.HandlerCompat
import java.util.concurrent.Executors

class Model private constructor() {
    private var executor = Executors.newSingleThreadExecutor()
    private var mainHandler = HandlerCompat.createAsync(Looper.getMainLooper())

//    fun getAllStudents(callback: StudentsCallback) {
//        val lastUpdated: Long = Student.lastUpdated
//
//        firebaseModel.getAllStudents(lastUpdated) { students ->
//            executor.execute {
//                var currentTime = lastUpdated
//                for (student in students) {
//                    database.studentDao().insertAll(student)
//                    student.lastUpdated?.let {
//                        if (currentTime < it) {
//                            currentTime = it
//                        }
//                    }
//                }
//
//                Student.lastUpdated = currentTime
//                val savedStudents = database.studentDao().getAllStudent()
//                mainHandler.post {
//                    callback(savedStudents)
//                }
//            }
//
//        }
//    }

//    fun add(student: Student, image: Bitmap?, storage: Storage, callback: EmptyCallback) {
//
//    }

//    private fun uploadTo(storage: Storage, image: Bitmap, name: String, callback: (String?) -> Unit) {
//        when (storage) {
//            Storage.FIREBASE -> {
//                uploadImageToFirebase(image, name, callback)
//            }
//            Storage.CLOUDINARY -> {
//                uploadImageToCloudinary(
//                    bitmap = image,
//                    name = name,
//                    onSuccess = callback,
//                    onError = { callback(null) }
//                )
//            }
//        }
//    }
//
//    fun delete(student: Student, callback: EmptyCallback) {
//        firebaseModel.delete(student, callback)
//    }
//
//    private fun uploadImageToFirebase(
//        image: Bitmap,
//        name: String,
//        callback: (String?) -> Unit
//    ) {
//        firebaseModel.uploadImage(image, name, callback)
//    }
//
//    private fun uploadImageToCloudinary(
//        bitmap: Bitmap,
//        name: String,
//        onSuccess: (String?) -> Unit,
//        onError: (String?) -> Unit
//    ) {
//        cloudinaryModel.uploadImage(
//            bitmap = bitmap,
//            name = name,
//            onSuccess = onSuccess,
//            onError = onError
//        )
//    }
}