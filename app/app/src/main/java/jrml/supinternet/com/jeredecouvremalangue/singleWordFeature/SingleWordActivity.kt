package jrml.supinternet.com.jeredecouvremalangue.singleWordFeature

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.LinearLayoutManager
import android.os.Bundle
import android.view.View
import android.widget.TextView
import jrml.supinternet.com.jeredecouvremalangue.R

class SingleWordActivity : AppCompatActivity() {
    var word: Word? = null
    var citationDisplayed: Boolean = false
    var nameText: TextView? = null
    var descriptionText: TextView? = null
    var citationView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_word)
        this.setAttribute()
        this.setWord()
        this.setRecyclerView()
        this.updateView()
        this.setListener()
        citationView?.visibility = View.GONE
    }

    private fun setWord() {
        val descList: ArrayList<String> = arrayListOf("Pardonnez-moi le style désultoire de ma lettre. — (Charles-Augustin Sainte-Beuve, Portraits littéraires, tome 3)",
                "Ce seront les mêmes promenades dans le parc, les mêmes conversations désultoires avec les fermiers. — (Marguerite Yourcenar, Quoi ? L’Éternité, Gallimard, 1988, page 78)")
        this.word = Word("désultoire", "Du latin desultorius," +
                " cheval qui sert à la voltige, de desultor, celui qui passe d’un objet à un autre, " +
                "proprement cavalier qui saute à bas de son cheval", descList)
    }

    private fun setAttribute(){
        nameText = findViewById<TextView>(R.id.name)
        descriptionText = findViewById<TextView>(R.id.description)
        citationView = findViewById<RecyclerView>(R.id.my_recycler_view)
    }

    private fun setRecyclerView(){
        val mRecyclerView = citationView

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView?.setHasFixedSize(true)

        // use a linear layout manager
        val mLayoutManager = LinearLayoutManager(this)
        mRecyclerView?.setLayoutManager(mLayoutManager)

        val arrayString = this.word?.citation

        // specify an adapter (see also next example)
        val mAdapter = CitationAdapter(arrayString?.toTypedArray())
        mRecyclerView?.setAdapter(mAdapter)
    }

    private fun updateView(){
        nameText?.text = word!!.name
        descriptionText?.text = word!!.description
    }

    private fun setListener(){
        val showCitation = findViewById<TextView>(R.id.some_citation_link)
        showCitation.setOnClickListener { _ ->
            if (citationDisplayed){
                citationView?.visibility = View.GONE
            }else{
                citationView?.visibility = View.VISIBLE
            }
            citationDisplayed = !citationDisplayed
        }
    }
}
