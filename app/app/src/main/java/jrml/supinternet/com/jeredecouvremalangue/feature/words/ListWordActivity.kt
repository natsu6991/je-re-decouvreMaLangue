package jrml.supinternet.com.jeredecouvremalangue.feature.words

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.LinearLayoutManager
import android.os.Bundle
import jrml.supinternet.com.jeredecouvremalangue.R
import jrml.supinternet.com.jeredecouvremalangue.data.WordService
import jrml.supinternet.com.jeredecouvremalangue.feature.word.Word

class ListWordActivity : AppCompatActivity() {

    private lateinit var words: HashMap<Int, Word>
    private lateinit var listView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_word)
        this.setAttribute()
        this.setWord()
        this.setRecyclerView()
    }

    private fun setWord(){
        this.words = WordService.getWords()
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
