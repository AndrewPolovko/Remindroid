package com.epam.androidlab.remindroid

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var mRecyclerView: RecyclerView
    lateinit var mFAB: FloatingActionButton
    var remindersList = ArrayList<Reminder>()
    lateinit var remindersAdapter: RemindersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mRecyclerView = findViewById(R.id.recycler_view) as RecyclerView
        mFAB = findViewById(R.id.fab) as FloatingActionButton

        remindersAdapter = RemindersAdapter(remindersList)
        mRecyclerView.adapter = RemindersAdapter(remindersList)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mRecyclerView.itemAnimator = DefaultItemAnimator()
        val itemDivider = ResourcesCompat.getDrawable(resources,R.drawable.recycler_view_item_divider,null) as Drawable
        mRecyclerView.addItemDecoration(RecyclerViewItemDecoration(itemDivider))

        mFAB.setOnClickListener {
            onFABClick()
        }
    }

    private fun onFABClick() {
        remindersList.add(Reminder())
        mRecyclerView.adapter.notifyItemInserted(remindersList.size)
        mRecyclerView.smoothScrollToPosition(remindersList.size)
    }
}
