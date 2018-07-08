package jrml.supinternet.com.jeredecouvremalangue.data

import jrml.supinternet.com.jeredecouvremalangue.feature.word.Word
import java.util.HashMap

interface WordService {
    fun getWords(): HashMap<Int, Word>
}