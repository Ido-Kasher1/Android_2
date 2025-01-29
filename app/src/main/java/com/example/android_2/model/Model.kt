package com.example.android_2.model

class Model private constructor() {

    val students: MutableList<Student> = ArrayList()
    companion object {
        val shared = Model()
    }

    init {
        students.add(Student("Liraz", "123", "Holon", "052-111", false))
        students.add(Student("Ido", "124", "LoYodea", "052-1231", true))
        students.add(Student("asdfasdf", "274357", "dfsghdfgh", "052-1114", false))
        students.add(Student("iuosdfngios", "78345", "hghhjrt", "052-11856", false))
        students.add(Student("zhesd", "845", "abc", "052-85966", true))
        students.add(Student("gfdhjfghj", "78345", "hghhjrt", "052-11856", false))
        students.add(Student("shyt", "457", "urety", "052-7896", false))
        students.add(Student("xcb", "35832", "qwerty", "052-5821", true))
        students.add(Student("cvbngg", "412237", "cade", "052-4357", true))
        students.add(Student("khgdjfd", "38555", "xcvbse", "052-582", true))
        students.add(Student("6rdgh", "7777", "sgdfh", "052-581", false))
    }
}