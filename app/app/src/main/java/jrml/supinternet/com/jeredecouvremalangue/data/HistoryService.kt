package jrml.supinternet.com.jeredecouvremalangue.data

import jrml.supinternet.com.jeredecouvremalangue.feature.word.Word

class HistoryService{
    companion object : WordService{
        var datas: ArrayList<Word> = ArrayList<Word>()

        fun addConsultedWord(word: Word){
            this.datas.add(word)
        }

        override fun getWords(): ArrayList<Word> {
            return datas
        }
    }
}