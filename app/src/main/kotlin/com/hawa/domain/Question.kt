package com.hawa.domain

import java.io.Serializable

/**
 * Created by prayagupd
 * on 1/2/17.
 */

class Question(
        internal var question: String,
        internal var rightAnswers: List<Answer>,
        internal var wrongAnswers: List<Answer>,
        internal var description: String
) : Serializable
