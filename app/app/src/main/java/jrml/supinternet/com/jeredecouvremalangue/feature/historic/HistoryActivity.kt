package jrml.supinternet.com.jeredecouvremalangue.feature.historic

import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import jrml.supinternet.com.jeredecouvremalangue.R
import jrml.supinternet.com.jeredecouvremalangue.data.HistoryService
import jrml.supinternet.com.jeredecouvremalangue.feature.words.ListWordActivity

class HistoryActivity : ListActivity() {
    override fun setService(){
        this.wordService = HistoryService
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
}
