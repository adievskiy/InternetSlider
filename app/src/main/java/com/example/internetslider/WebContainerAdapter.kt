package com.example.internetslider

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class WebContainerAdapter(fragment: FragmentActivity, private val webList: MutableList<WebContainer>) :
    FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return webList.size
    }

    override fun createFragment(position: Int): Fragment {
        val fragment = WebFragment()
        fragment.arguments = bundleOf("role" to webList[position])
        return fragment
    }
}