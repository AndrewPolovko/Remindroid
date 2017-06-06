package com.epam.androidlab.remindroid

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.epam.androidlab.remindroid.activities.ActivityEditEvent


class EventsAdapter(var eventsList: ArrayList<Event>) : RecyclerView.Adapter<EventsAdapter.EventHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return EventHolder(view)
    }

    inner class EventHolder(var view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.event_title) as TextView
        val date: TextView = view.findViewById(R.id.event_date) as TextView
        val time: TextView = view.findViewById(R.id.event_time) as TextView
        val note: TextView = view.findViewById(R.id.event_note) as TextView
        val id: TextView = view.findViewById(R.id.event_id) as TextView

        init {
            view.setOnClickListener {
                val intent = Intent(view.context, ActivityEditEvent::class.java)
                intent.putExtra(MyConstants.FLAG_EDIT_EXISTING_EVENT, true)
                view.context.startActivity(intent)
                Toast.makeText(view.context, "$adapterPosition", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onBindViewHolder(holder: EventHolder, position: Int) {
        val event = eventsList[position]
        holder.title.text = event.title
        holder.date.text = event.date
        holder.time.text = event.time
        holder.note.text = event.note
        holder.id.text = event.id.toString()
    }

    override fun getItemCount(): Int {
        return eventsList.size
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }
}