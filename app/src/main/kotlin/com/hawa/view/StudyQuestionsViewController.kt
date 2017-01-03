package com.hawa.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ListView
import com.hawa.R
import com.hawa.domain.Answer
import com.hawa.domain.Question
import com.hawa.domain.Topic
import java.util.*


class StudyQuestionsViewController : AppCompatActivity() {

    lateinit var studyQuestionsUi: ListView
    var questionsData: List<Question> = ArrayList<Question>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.study_questions_view)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val topic = intent.getSerializableExtra("topic") as Topic
        this.title = topic.title

        studyQuestionsUi = findViewById(R.id.studyQuestions) as ListView

        renderTopics()
    }


    private fun renderTopics() {
        val questionsStream = QuestionsStream(applicationContext, questionsData)
        studyQuestionsUi.adapter = questionsStream

        Thread(null, Runnable {
            questionsData =
                    mutableListOf(Question("Who is the first PM of USA?",
                            mutableListOf(Answer("George Washington",
                                    "George Washington was an American soldier and statesman who " +
                                            "served as the first President of the United States from 1789 to 1797.")),
                            mutableListOf(),
                            "USA has 35 PMs so far."),

                            Question("World War I began in which year?",
                                    mutableListOf(Answer("July 28, 1914",
                                            "http://www.history.com/topics/world-war-i/outbreak-of-world-war-i")),
                                    mutableListOf(Answer("November 11, 1918", "")),
                                    "The total number of military and civilian casualties in World War I was more than 38 million"),
                            Question("What was the motto of the arms of England during the reigns of Elizabeth I and Anne?",
                                    mutableListOf(Answer("Semper Eadem",
                                            "Semper Eadem means 'always the same'. It was a phrase used by Elizabeth's mother, Queen Anne Boleyn, and was re-adopted by Anne when she was queen. Anne's earlier Stuart relatives on the English throne used the motto Dieu et Mon Droit")),
                                    mutableListOf(Answer("November 11, 1918", "")), ""),
                            Question("When was the Euro first used as a unit of currency?",
                                    mutableListOf(Answer("1999", "")),
                                    mutableListOf(Answer("November 11, 1918", "")), ""),
                            Question("French aviator Louis Bleriot was the first to do what in an aeroplane on 25 July 1909?",
                                    mutableListOf(Answer("Cross the English Channel", "")),
                                    mutableListOf(Answer("", "")), "")
                    )
            Handler(Looper.getMainLooper()).post({
                if (questionsData.isNotEmpty()) {
                    questionsData.forEach { questionsStream.add(it) }
                    questionsStream.notifyDataSetChanged()
                    studyQuestionsUi.visibility = View.VISIBLE
                }
            })
        }).start()
    }
}
