package com.epam.androidlab.remindroid.activities

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import com.epam.androidlab.remindroid.*

class ActivityMain : AppCompatActivity() {

    lateinit var mToolbar: Toolbar
    lateinit var mRecyclerView: RecyclerView
    lateinit var mFAB: FloatingActionButton
    var eventsList = ArrayList<Event>()
    lateinit var eventsAdapter: EventsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        eventsAdapter = EventsAdapter(eventsList)
        mRecyclerView.adapter = EventsAdapter(eventsList)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mRecyclerView.itemAnimator = DefaultItemAnimator()
        val itemDivider = ResourcesCompat.getDrawable(resources, R.drawable.recycler_view_item_divider, null) as Drawable
        mRecyclerView.addItemDecoration(RecyclerViewItemDecoration(itemDivider))

        mFAB.setOnClickListener {
            onFABClick()
        }
    }

    private fun init() {
        mToolbar = findViewById(R.id.my_toolbar) as Toolbar
        mRecyclerView = findViewById(R.id.recycler_view) as RecyclerView
        mFAB = findViewById(R.id.fab_add) as FloatingActionButton
        setSupportActionBar(mToolbar)
    }

    private fun onFABClick() {
        val intent = android.content.Intent(this, ActivityEditEvent::class.java)
        intent.putExtra(MyConstants.Companion.FLAG_CREATE_NEW_EVENT, true)
        startActivity(intent)
        /*eventsList.add(Event())
        mRecyclerView.adapter.notifyItemInserted(eventsList.size)
        mRecyclerView.smoothScrollToPosition(eventsList.size)*/
    }
}
