package com.example.android_2.Model

import android.content.Context
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android_2.MainActivity

@Entity
data class Student(
    @PrimaryKey val id: String,
    val name: String,
    val avatarUrl: String,
    var isChecked: Boolean,
    val lastUpdated: Long? = null
) {

    companion object {

//        var lastUpdated: Long
//            get() = MainActivity.Globals.context?.getSharedPreferences("TAG", Context.MODE_PRIVATE)
//                ?.getLong(LOCAL_LAST_UPDATED, 0) ?: 0
//
//            set(value) {
//                MainActivity.Globals.context
//                    ?.getSharedPreferences("TAG", Context.MODE_PRIVATE)?.apply {
//                        edit().putLong(LOCAL_LAST_UPDATED, value).apply()
//                    }
//            }
//

        const val ID_KEY = "id"
        const val NAME_KEY = "name"
        const val AVATAR_URL_KEY = "avatarUrl"
        const val IS_CHECKED_KEY = "isChecked"
        const val LAST_UPDATED = "lastUpdated"
        const val LOCAL_LAST_UPDATED = "locaStudentLastUpdated"

        fun fromJSON(json: Map<String, Any>): Student {
            val id = json[ID_KEY] as? String ?: ""
            val name = json[NAME_KEY] as? String ?: ""
            val avatarUrl = json[AVATAR_URL_KEY] as? String ?: ""
            val isChecked = json[IS_CHECKED_KEY] as? Boolean ?: false
            return Student(
                id = id,
                name = name,
                avatarUrl = avatarUrl,
                isChecked = isChecked
            )
        }
    }

    val json: Map<String, Any>
        get() = hashMapOf(
            ID_KEY to id,
            NAME_KEY to name,
            AVATAR_URL_KEY to avatarUrl,
            IS_CHECKED_KEY to isChecked
        )

}