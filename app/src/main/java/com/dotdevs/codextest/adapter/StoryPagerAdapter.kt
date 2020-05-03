package com.dotdevs.codextest.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dotdevs.codextest.ui.fragment.SavedStoryFragment
import com.dotdevs.codextest.ui.fragment.TopStoryFragment
import java.lang.IndexOutOfBoundsException

const val TOP_STORY_PAGE_INDEX = 0
const val SAVED_STORY_PAGE_INDEX = 1

class NewsPagerAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {

    private val tabFragmentCreators: Map<Int, () -> Fragment> = mapOf(
        TOP_STORY_PAGE_INDEX to { TopStoryFragment() },
        SAVED_STORY_PAGE_INDEX to { SavedStoryFragment() }
    )

    override fun getItemCount(): Int = tabFragmentCreators.size

    override fun createFragment(position: Int): Fragment {
        return tabFragmentCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
}