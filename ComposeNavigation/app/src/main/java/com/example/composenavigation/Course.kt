package com.example.composenavigation

import androidx.annotation.DrawableRes

data class Course(

    val title : String,
    val rating : Float,
    @DrawableRes val thumbnail : Int,
    val body : String

)

val course1 : Course = Course(
    "The Complete Android 13 Developer Course - Build 52 Apps",
    4.5f,
    R.drawable.course,
    "Learn Android App Development from Zero To Hero - Build 50+Apps from scratch - Nah Bro"

)
val course2 : Course = Course(
    "Mastering Android App Development With kotlin - Build 38 apps",
    4.5f,
    R.drawable.ic_launcher_foreground,
    "Learn AAndroid Kotlin from Zeero to Hero - Builds apps with MVVM, Retrofit, ROOM DB, Firebase, Jetpack, MYSQL, JSON & More"
)
val course3 : Course = Course(
    "Mastering Design Patterns - Become Professional Developer",
    4.7f,
    R.drawable.ic_launcher_foreground,
    "Become a Professional Software Engineer, excel in university Exams & Succeed in coding Interviews"
)
val course4 : Course = Course(
    "The Complete Firebase & Android Course - Mastering Firebase ",
    4.4f,
    R.drawable.ic_launcher_foreground,
    "Master Firebase Products from zero to hero"
)
val course5 : Course = Course(
    "The Complete Java Developer Course - Mastering Java from Zero",
    4.6f,
    R.drawable.ic_launcher_foreground,
    "Learn Java from Zero to Hero, Become A computer programmer and start building complex projects, Earn Java Certification"
)
val course6 : Course = Course(
    "The Complete Android jetpack Course - Mastering Jetpack",
    4.8f,
    R.drawable.ic_launcher_foreground,
    "Become a professional Android Developer by Mastering ROOM, MVVM, Retrofit, Navigation , WorkManager, Dagger, Paging3 & More"
)

val course7 : Course = Course(
    "The Complete Data Structure & Algorithm Course in C & Java",
    4.6f,
    R.drawable.ic_launcher_foreground,
    "Master the Coding Interview : Data Structures & Algorithms with fully animated videos and over 108 real life problems"
)
val course8 : Course = Course(
    "The Complete Kotlin Course -  Mastering kotlin From zero To Hero",
    4.4f,
    R.drawable.ic_launcher_foreground,
    "Mastering Kotlin from scratch and enhancing your coding career prospects"
)

val courses : List<Course> = mutableListOf(

    course1, course2,
    course3, course4,
    course5, course6,
    course7, course8
)
