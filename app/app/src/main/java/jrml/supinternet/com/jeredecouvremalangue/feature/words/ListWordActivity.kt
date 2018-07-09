package jrml.supinternet.com.jeredecouvremalangue.feature.words

import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import jrml.supinternet.com.jeredecouvremalangue.R
import jrml.supinternet.com.jeredecouvremalangue.feature.historic.ListActivity
import jrml.supinternet.com.jeredecouvremalangue.data.ListWordService
import jrml.supinternet.com.jeredecouvremalangue.feature.historic.HistoryActivity

class ListWordActivity : ListActivity() {
    override fun setService(){
        this.wordService = ListWordService
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.history_items, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.history -> {
                val intent = Intent(this, HistoryActivity::class.java)
                this.startActivity(intent)
            }
            else -> return super.onOptionsItemSelected(item)
        }

        return true
    }
}
