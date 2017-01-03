package com.hawa.domain

import java.io.Serializable

/**
 * Created by prayagupd
 * on 1/2/17.
 */

class Question(
        var question: String,
        var rightAnswers: List<Answer>,
        var wrongAnswers: List<Answer>,
        var description: String
) : Serializable
