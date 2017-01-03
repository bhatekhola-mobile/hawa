package com.hawa.view

import android.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.hawa.R
import com.hawa.view.TopicsStream
import com.hawa.domain.Topic
import com.hawa.view.StudyQuestionsViewController
import java.util.*

class StudyFragmentView : Fragment() {

    lateinit var topicsUi: ListView
    var topics: List<Topic> = ArrayList<Topic>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.study_view, container, false)

        topicsUi = rootView.findViewById(R.id.topics) as ListView

        renderTopics(rootView)

        topicsUi.setOnItemClickListener { adapterView, view, postion, id ->
            val selectedTopic = topicsUi.getItemAtPosition(postion) as Topic
            val intent = Intent(context, StudyQuestionsViewController::class.java)
            //FIXME context needs sdkVersion to be 23, which means won't run on earlier version
            // like 11.
            intent.putExtra("topic", selectedTopic)
            startActivity(intent)
        }
        return rootView
    }

    private fun renderTopics(rootView: View) {
        val topicStream = TopicsStream(this.activity, topics)
        topicsUi.adapter = topicStream

        Thread(null, Runnable {
            topics = mutableListOf(Topic("History", 40),
                    Topic("Geography", 60),
                    Topic("Entertainment, Literature", 40),
                    Topic("Culture", 56),
                    Topic("Education", 89),
                    Topic("Health", 77),
                    Topic("Economy", 76),
                    Topic("Politics", 54))
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
