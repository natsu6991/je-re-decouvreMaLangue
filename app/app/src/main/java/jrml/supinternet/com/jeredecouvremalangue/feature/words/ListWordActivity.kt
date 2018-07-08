package jrml.supinternet.com.jeredecouvremalangue.feature.words

import jrml.supinternet.com.jeredecouvremalangue.feature.historic.ListActivity
import jrml.supinternet.com.jeredecouvremalangue.data.ListWordService

class ListWordActivity : ListActivity() {
    override fun setService(){
        this.wordService = ListWordService
    }
}
