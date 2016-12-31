package com.hawa

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

import java.util.ArrayList

/**
 * Created by prayagupd
 * on 12/31/16.
 */

class TopicsStream(context: Context, objects: List<Topic>) : ArrayAdapter<Topic>(context, 0, objects) {

    private val layoutInflater: LayoutInflater

    init {
        this.layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var topicsUi = convertView

        if (topicsUi == null) {
            topicsUi = layoutInflater.inflate(R.layout.study_list_view, parent, false)

            val holder = TopicViewHolder(topicsUi.findViewById(R.id.topicTitle) as TextView,
                    topicsUi.findViewById(R.id.topicQuestions) as TextView)

            topicsUi.tag = holder
        }

        val topicItem = getItem(position)
        val holder = topicsUi!!.tag as TopicViewHolder
        holder.title.text = topicItem.title
        holder.questions.text = topicItem.questions.toString()

        return topicsUi
    }

    class TopicViewHolder(var title: TextView, var questions: TextView)
}
