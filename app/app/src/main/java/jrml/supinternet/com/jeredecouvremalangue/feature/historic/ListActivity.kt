package jrml.supinternet.com.jeredecouvremalangue.feature.historic

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import jrml.supinternet.com.jeredecouvremalangue.R
import jrml.supinternet.com.jeredecouvremalangue.data.ListWordService
import jrml.supinternet.com.jeredecouvremalangue.data.WordService
import jrml.supinternet.com.jeredecouvremalangue.feature.word.Word
import jrml.supinternet.com.jeredecouvremalangue.feature.words.ListAdapter
import java.util.HashMap

abstract class ListActivity : AppCompatActivity() {

    private lateinit var words: HashMap<Int, Word>
    private lateinit var listView: RecyclerView
    protected lateinit var wordService: WordService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_word)
        this.setAttribute()
        this.setService()
        this.setWord()
        this.setRecyclerView()
    }

    protected abstract fun setService()

    private fun setWord(){
        this.words = this.wordService.getWords()
    }

    private fun setAttribute(){
        listView = findViewById<RecyclerView>(R.id.my_recycler_word_view)
    }

    private fun setRecyclerView(){
        val mRecyclerView = listView
        mRecyclerView.setHasFixedSize(true)
        val mLayoutManager = LinearLayoutManager(this)
        mRecyclerView.setLayoutManager(mLayoutManager)
        var arrayString: Array<String> = arrayOf<String>()
        for (word: Word in this.words.values){
            arrayString += word.name
        }
        val mAdapter = ListAdapter(arrayString)
        mRecyclerView.setAdapter(mAdapter)
    }
}