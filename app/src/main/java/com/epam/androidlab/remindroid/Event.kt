package com.epam.androidlab.remindroid

class Event @JvmOverloads constructor(var title: String = "",
                                      var date: String = "",
                                      var time: String = "",
                                      var note: String = "",
                                      val id: Long = System.currentTimeMillis())