package com.hawa.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.hawa.R
import com.hawa.domain.Question
import com.hawa.domain.Topic

import java.util.ArrayList

/**
 * Created by prayagupd
 * on 12/31/16.
 */

class QuestionsStream(context: Context, objects: List<Question>) : ArrayAdapter<Question>(context, 0, objects) {

    private val layoutInflater: LayoutInflater
    val view_template = R.layout.study_questions_template

    init {
        this.layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var ui = convertView

        if (ui == null) {

            ui = layoutInflater.inflate(view_template, parent, false)

            val holder = QuestionViewHolder(ui.findViewById(R.id.question) as TextView,
                    ui.findViewById(R.id.answer) as TextView)

            ui.tag = holder
        }

        val questionItem = getItem(position)
        val holder = ui!!.tag as QuestionViewHolder
        holder.question.text = questionItem.question
        holder.answer.text = questionItem.rightAnswers.first().answer.toString()

        return ui
    }

    class QuestionViewHolder(var question: TextView, var answer: TextView)
}
