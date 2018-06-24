package jrml.supinternet.com.jeredecouvremalangue.feature.word

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.LinearLayoutManager
import android.os.Bundle
import android.view.View
import android.widget.TextView
import jrml.supinternet.com.jeredecouvremalangue.R
import jrml.supinternet.com.jeredecouvremalangue.data.WordService

class SingleWordActivity : AppCompatActivity() {
    private lateinit var word: Word
    private var citationDisplayed = false
    /*private lateinit var nameText: TextView
    private lateinit var descriptionText: TextView*/
    private lateinit var wordView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_word)
        this.setAttribute()
        this.setWord()
        this.setRecyclerView()
        //this.updateView()
        //this.setListener()
    }

    private fun setWord() {
        this.word = WordService.getWord(1)!!
    }

    private fun setAttribute(){
        /*nameText = findViewById<TextView>(R.id.name)
        descriptionText = findViewById<TextView>(R.id.description)*/
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

        val arrayString = this.word.citation

        // specify an adapter (see also next example)
        val mAdapter = WordAdapter(arrayString?.toTypedArray(), getString(R.string.citation_text))
        mRecyclerView.adapter = mAdapter
    }

    /*private fun updateView(){
        nameText.text = word.name
        descriptionText.text = word.description
    }*/

    /*private fun setListener(){
        val showCitation = findViewById<TextView>(R.id.some_citation_link)
        showCitation.setOnClickListener { _ ->
            if (citationDisplayed){
                citationView.visibility = View.GONE
            }else{
                citationView.visibility = View.VISIBLE
            }
            citationDisplayed = !citationDisplayed
        }
    }*/
}
