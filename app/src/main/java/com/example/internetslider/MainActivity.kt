package com.example.internetslider

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private val web = WebContainer.webContainer
    private lateinit var adapter: WebContainerAdapter
    private lateinit var viewPagerVP: ViewPager2
    private lateinit var tabLayoutTL: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        adapter = WebContainerAdapter(this, web)
        viewPagerVP = findViewById(R.id.viewPagerVP)
        tabLayoutTL = findViewById(R.id.tabLayoutTL)
        viewPagerVP.adapter = adapter

        TabLayoutMediator(tabLayoutTL, viewPagerVP) { tab, position ->
            val name = web[position].name
            tab.text = name
            tab.setIcon(web[position].image)
        }.attach()
    }
}