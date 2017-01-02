package com.hawa

import android.app.Fragment
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import java.util.*

class StudyFragmentView : Fragment() {

    lateinit var topicsUi: ListView
    var topics: List<Topic> = ArrayList<Topic>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.study_view, container, false)
        renderTopics(rootView)
        return rootView
    }

    private fun renderTopics(rootView: View) {
        topicsUi = rootView.findViewById(R.id.topics) as ListView
        val topicStream = TopicsStream(this.activity, topics)
        topicsUi.adapter = topicStream

        Thread(null, Runnable {
            topics = mutableListOf(Topic("History", 40), Topic("Geography", 60))
            Handler(Looper.getMainLooper()).post({
                if(topics.isNotEmpty()) {
                    topics.forEach { topicStream.add(it) }
                    topicStream.notifyDataSetChanged()
                    topicsUi.visibility = View.VISIBLE
                }
            })
        }).start()
    }
}
