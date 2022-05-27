package com.wajahatkarim3.easyflipviewpager.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.wajahatkarim3.easyflipviewpager.BookFlipPageTransformer

class BookOnboardingActivity : AppCompatActivity() {

    private lateinit var mPager: ViewPager
    private var mPagerAdapter: PagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_onboarding)

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = findViewById(R.id.pager)
        mPagerAdapter = BookOnboardingPagerAdapter(supportFragmentManager)
        mPager.adapter = mPagerAdapter
        mPager.clipToPadding = true
        mPager.setPageTransformer(true, BookFlipPageTransformer())
    }

    class BookOnboardingPagerAdapter : FragmentPagerAdapter
    {
        var fragments = arrayListOf<BookPageIntroFragment>()

        constructor(fm: FragmentManager) : super(fm)
        {

            val imageIds = intArrayOf(R.drawable.all_about_reading, R.drawable.find_your_love, R.drawable.pick_your_books,
                R.drawable.all_about_reading
            )

            for (i in 0..3)
            {
                var frag = BookPageIntroFragment.newInstance(imageIds[i])
                fragments.add(frag)
            }
        }

        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        override fun getCount(): Int {
            return fragments.size
        }
    }
}
