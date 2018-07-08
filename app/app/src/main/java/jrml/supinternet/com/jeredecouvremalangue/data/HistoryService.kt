package jrml.supinternet.com.jeredecouvremalangue.data

import jrml.supinternet.com.jeredecouvremalangue.feature.word.Word
import java.util.HashMap

class HistoryService{
    companion object : WordService{
        var datas: ArrayList<Int> = ArrayList<Int>()

        fun addConsultedWordId(wordId: Int){
            //todo
        }

        override fun getWords(): HashMap<Int, Word> {
            //todo
        }
    }
}