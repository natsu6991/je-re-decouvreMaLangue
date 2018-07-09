package jrml.supinternet.com.jeredecouvremalangue.feature.word

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.LinearLayoutManager
import android.os.Bundle
import android.view.MenuItem
import jrml.supinternet.com.jeredecouvremalangue.R
import jrml.supinternet.com.jeredecouvremalangue.data.ListWordService
import jrml.supinternet.com.jeredecouvremalangue.data.HistoryService
import android.content.Intent
import android.view.ContextMenu
import android.view.Menu
import android.view.View
import jrml.supinternet.com.jeredecouvremalangue.feature.words.ListWordActivity


class SingleWordActivity : AppCompatActivity() {
    private lateinit var word: Word
    //private var citationDisplayed = false

    private lateinit var wordView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_word)
        val wordId = intent.getIntExtra("listId", 1000)

        this.setAttribute()
        this.setWord(wordId)
        this.setRecyclerView()
        //this.setListener()
        this.setSupportActionBar(findViewById(R.id.my_toolbar))
    }

    private fun setWord(wordId: Int) {
        this.word = ListWordService.getWord(wordId)!!
        HistoryService.addConsultedWord(this.word)
    }

    private fun setAttribute(){
        wordView = findViewById<RecyclerView>(R.id.word_recycler_view)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_items, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.main -> {
                val intent = Intent(this, ListWordActivity::class.java)
                this.startActivity(intent)
            }
            else -> return super.onOptionsItemSelected(item)
        }

        return true
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
