package com.epam.androidlab.remindroid

class Reminder @JvmOverloads constructor(var title: String = "",
                                         var description: String = "",
                                         var date: String = "",
                                         val id: Long = System.currentTimeMillis())