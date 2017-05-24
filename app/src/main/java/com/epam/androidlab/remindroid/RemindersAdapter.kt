package com.epam.androidlab.remindroid

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class RemindersAdapter(var remindersList: ArrayList<Reminder>) : RecyclerView.Adapter<RemindersAdapter.ReminderHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReminderHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return ReminderHolder(view)
    }

    inner class ReminderHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.reminder_title) as TextView
        val description: TextView = view.findViewById(R.id.reminder_description) as TextView
        val date: TextView = view.findViewById(R.id.reminder_date) as TextView
        val id: TextView = view.findViewById(R.id.reminder_id) as TextView
    }

    override fun onBindViewHolder(holder: ReminderHolder, position: Int) {
        val reminder = remindersList[position]
        holder.title.text = reminder.title
        holder.description.text = reminder.description
        holder.date.text = reminder.date
        holder.id.text = reminder.id.toString()
    }

    override fun getItemCount(): Int {
        return remindersList.size
    }
}