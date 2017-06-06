package com.epam.androidlab.remindroid.activities

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.epam.androidlab.remindroid.MyConstants
import com.epam.androidlab.remindroid.R

class ActivityEditEvent : AppCompatActivity() {
    lateinit var mToolbar: Toolbar
    lateinit var title: EditText
    lateinit var date: TextView
    lateinit var time: TextView
    lateinit var note: EditText
    lateinit var fab: FloatingActionButton
    var flagCreateNewEvent = false
    var flagEditExistingEvent = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_event)

        init()

        extractDataFromIntent()
        if (flagEditExistingEvent)
            setEventInfoFromIntent()
    }

    private fun init() {
        mToolbar = findViewById(R.id.my_toolbar) as Toolbar
        title = findViewById(R.id.event_title) as EditText
        date = findViewById(R.id.event_date) as TextView
        time = findViewById(R.id.event_time) as TextView
        note = findViewById(R.id.event_note) as EditText
        fab = findViewById(R.id.fab_ok) as FloatingActionButton

        fab.setOnClickListener { onFABClick() }

        setSupportActionBar(mToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun extractDataFromIntent() {
        flagCreateNewEvent = intent.getBooleanExtra(MyConstants.FLAG_CREATE_NEW_EVENT, false)
        flagEditExistingEvent = intent.getBooleanExtra(MyConstants.FLAG_EDIT_EXISTING_EVENT, false)
    }

    private fun setEventInfoFromIntent() {
        TODO()
    }

    private fun onFABClick() {
        if (title.text.toString() == "" || date.text.toString() == "") {
            Toast.makeText(this, "Title or date cannot be empty", Toast.LENGTH_SHORT).show()
            return
        }
        saveEvent()
    }

    private fun saveEvent() {
        TODO()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
