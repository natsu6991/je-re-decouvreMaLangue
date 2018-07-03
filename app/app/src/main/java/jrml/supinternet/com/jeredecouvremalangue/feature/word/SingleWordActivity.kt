package jrml.supinternet.com.jeredecouvremalangue.feature.word

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.LinearLayoutManager
import android.os.Bundle
import android.util.Log
import jrml.supinternet.com.jeredecouvremalangue.R
import jrml.supinternet.com.jeredecouvremalangue.data.WordService

class SingleWordActivity : AppCompatActivity() {
    private lateinit var word: Word
    //private var citationDisplayed = false

    private lateinit var wordView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_word)
        val wordId = intent.getIntExtra("listId", 1000)
        Log.d("JS\\singleWordActivity", "id is " + wordId)

        this.setAttribute()
        this.setWord(wordId)
        this.setRecyclerView()
        //this.setListener()
    }

    private fun setWord(wordId: Int) {
        this.word = WordService.getWord(wordId)!!
    }

    private fun setAttribute(){
        wordView = findViewById<RecyclerView>(R.id.word_recycler_view)
    }

    private fun setRecyclerView(){
        val mRecyclerView = wordView

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true)

        // use a linear layout manager
        val mLayoutManager = LinearLayoutManager(this)
        mRecyclerView.layoutManager = mLayoutManager

        // specify an adapter (see also next example)
        val mAdapter = WordAdapter(this.word, getString(R.string.citation_text))
        mRecyclerView.adapter = mAdapter
    }

}
