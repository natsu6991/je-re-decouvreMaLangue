package jrml.supinternet.com.jeredecouvremalangue.singleWordFeature

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import jrml.supinternet.com.jeredecouvremalangue.R

class SingleWordActivity : AppCompatActivity() {
    var word: Word? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_word)
        this.setWord()
        this.updateView()
    }

    private fun setWord() {
        val descList: ArrayList<String> = arrayListOf("Pardonnez-moi le style désultoire de ma lettre. — (Charles-Augustin Sainte-Beuve, Portraits littéraires, tome 3)",
                "Ce seront les mêmes promenades dans le parc, les mêmes conversations désultoires avec les fermiers. — (Marguerite Yourcenar, Quoi ? L’Éternité, Gallimard, 1988, page 78)")
        this.word = Word("désultoire", "Du latin desultorius," +
                " cheval qui sert à la voltige, de desultor, celui qui passe d’un objet à un autre, " +
                "proprement cavalier qui saute à bas de son cheval", descList)
    }

    private fun updateView(){

    }
}
