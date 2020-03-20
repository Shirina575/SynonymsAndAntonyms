package com.github.shirina575.synonymsandantonyms

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var searchButton: Button
    lateinit var searchText: EditText
    lateinit var searchTextResult: TextView
    private val TAG = "MainActivity"

    private var mAdView: AdView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MobileAds.initialize(this) {}
        mAdView = findViewById(R.id.adView);
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)

       searchButton = findViewById(R.id.searchButton)
        searchText = findViewById(R.id.searchText)
        searchTextResult = findViewById(R.id.showSearchResult)
        searchButton.setOnClickListener{

            startActivity(Intent(this@MainActivity, WordMeaning::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_settings){
            startActivity(Intent(this@MainActivity, Settings::class.java))
            return true
        }
        var selectedOption = ""
        when(item?.itemId){
            R.id.menu_synonymsAndAntonyms -> selectedOption = "Synonyms And Antonyms."
            R.id.menu_settings -> selectedOption = "Settings."
            R.id.menu_about -> selectedOption = "About."
            R.id.menu_share -> selectedOption = "Share This App."
        }
        Toast.makeText(this, selectedOption,Toast.LENGTH_SHORT).show()
        return super.onOptionsItemSelected(item)
    }

}
