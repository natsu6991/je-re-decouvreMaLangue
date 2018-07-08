package jrml.supinternet.com.jeredecouvremalangue.feature.historic

import jrml.supinternet.com.jeredecouvremalangue.data.HistoryService

class HistoryActivity : ListActivity() {
    override fun setService(){
        this.wordService = HistoryService
    }
}
