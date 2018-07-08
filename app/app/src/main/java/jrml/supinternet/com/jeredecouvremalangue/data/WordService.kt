package jrml.supinternet.com.jeredecouvremalangue.data

import jrml.supinternet.com.jeredecouvremalangue.feature.word.Word

interface WordService {
    fun getWords(): ArrayList<Word>
}