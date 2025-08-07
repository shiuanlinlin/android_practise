package com.example.playground

//const val App_name = "MyApp"

fun main() {
    val name: String = "aaa"
    val age: Int = 20
    var isStudent = true
    val startTime = System.currentTimeMillis()


    println("startTime $startTime")
    println(name)
    println(name::class.simpleName)
    println("我的年紀 ($age+${1})")
    println("我的年紀"+(age+1))
    println(isStudent)

    isStudent = false
    println(isStudent)
    println("Hello")
}