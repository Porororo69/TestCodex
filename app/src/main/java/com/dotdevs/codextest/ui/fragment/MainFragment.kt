package com.dotdevs.codextest.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.dotdevs.codextest.R
import com.dotdevs.codextest.adapter.NewsPagerAdapter
import com.dotdevs.codextest.adapter.SAVED_STORY_PAGE_INDEX
import com.dotdevs.codextest.adapter.TOP_STORY_PAGE_INDEX
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment: Fragment(R.layout.main_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPager.adapter = NewsPagerAdapter(this)

        TabLayoutMediator(tabLayout, viewPager) {tab, position ->
            tab.setIcon(getTabIcon(position))
            tab.text = getTabTitle(position)
        }.attach()
    }

    private fun getTabIcon(position: Int): Int {
        return when(position){
            TOP_STORY_PAGE_INDEX -> R.drawable.top_story_tab_selector
            SAVED_STORY_PAGE_INDEX -> R.drawable.save_story_tab_selector
            else -> throw IndexOutOfBoundsException()
        }
    }

    private fun getTabTitle(position: Int): String? {
        return when(position){
            TOP_STORY_PAGE_INDEX -> "Top Story"
            SAVED_STORY_PAGE_INDEX -> "Saved Story"
            else -> null
        }
    }

}