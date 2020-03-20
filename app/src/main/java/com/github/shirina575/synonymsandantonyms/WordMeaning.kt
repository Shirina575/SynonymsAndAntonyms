package com.github.shirina575.synonymsandantonyms

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.github.shirina575.synonymsandantonyms.Fragment.FragmentAntonyms
import com.github.shirina575.synonymsandantonyms.Fragment.FragmentDefinition
import com.github.shirina575.synonymsandantonyms.Fragment.FragmentExamples
import com.github.shirina575.synonymsandantonyms.Fragment.FragmentSynonyms
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_word_meaning.*

class WordMeaning : AppCompatActivity() {

    //var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null
    lateinit var tDefinition: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word_meaning)

        setSupportActionBar(toolbar)
        supportActionBar?.setTitle("Meaning")
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp)
        viewPager = findViewById(R.id.tab_viewPager)

        setUpViewPager(viewPager)
        tDefinition = findViewById(R.id.textDef)

//        tabLayout = findViewById(R.id.tabLayout)
//        tabLayout!!.addTab(tabLayout!!.newTab().setText("Definition"))
//        tabLayout!!.addTab(tabLayout!!.newTab().setText("Synonyms"))
//        tabLayout!!.addTab(tabLayout!!.newTab().setText("Antonyms"))
//        tabLayout!!.addTab(tabLayout!!.newTab().setText("Examples"))
//        tabLayout!!.tabGravity = TabLayout.GRAVITY_FILL
        //tabLayout!!.setupWithViewPager(viewPager)

//        viewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
//        tabLayout!!.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
//            override fun onTabReselected(tab: TabLayout.Tab?) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab?) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onTabSelected(tab: TabLayout.Tab?) {
//                TODO("Not yet implemented")
//                viewPager!!.currentItem = tab!!.position
//            }
//
//        })
    }

    private class ViewPagerAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager){
        private val mFragmentList: ArrayList<Fragment> = ArrayList()
        private val mFragmentTitleList: ArrayList<String> = ArrayList()


        override fun getItem(position: Int): Fragment{
            return mFragmentList.get(position)
        }

        override fun getCount(): Int {
            return mFragmentList.size
            TODO("Not yet implemented")
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return mFragmentTitleList.get(position)
        }

        fun addFragment(fragment: Fragment, title: String){
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
        }
    }
    private fun setUpViewPager(viewPager: ViewPager?){
       val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPagerAdapter.addFragment(FragmentDefinition(), "Definition")
//        viewPagerAdapter.addFragment(FragmentSynonyms(), "Synonyms")
//        viewPagerAdapter.addFragment(FragmentAntonyms(), "Antonyms")
//        viewPagerAdapter.addFragment(FragmentExamples(), "Examples")
        viewPager!!.adapter = viewPagerAdapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}
