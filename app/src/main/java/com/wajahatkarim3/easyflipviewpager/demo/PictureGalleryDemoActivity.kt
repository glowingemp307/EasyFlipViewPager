package com.wajahatkarim3.easyflipviewpager.demo

import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.wajahatkarim3.easyflipviewpager.CardFlipPageTransformer

class PictureGalleryDemoActivity : AppCompatActivity() {

    lateinit var galleryViewPager: ViewPager
    lateinit var pagerAdapter: GalleryPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture_gallery_demo)

        galleryViewPager = findViewById(R.id.galleryViewPager)
        pagerAdapter = GalleryPagerAdapter(supportFragmentManager)
        galleryViewPager.adapter = pagerAdapter

        var pageTransformer = CardFlipPageTransformer()
        pageTransformer.flipOrientation = CardFlipPageTransformer.VERTICAL
        pageTransformer.isScalable = true
        galleryViewPager.setPageTransformer(true, pageTransformer)
    }

    class GalleryPagerAdapter : FragmentPagerAdapter
    {
        var fragmentsList = arrayListOf<GalleryImageFragment>()

        constructor(fm: FragmentManager) : super(fm)
        {

            val imageIds = intArrayOf(
                    R.drawable.img_naltar_valley,
                    R.drawable.img_neelum_valley,
                    R.drawable.img_shangrila,
                    R.drawable.img_gojal_valley,
                    R.drawable.img_deosai_plains,
                    R.drawable.img_rama_meadow,
                    R.drawable.img_ayun_valley,
                    R.drawable.img_ghanche,
                    R.drawable.img_ranikot,
                    R.drawable.img_gorakh_hill
            )

            for (i in 0 until imageIds.size)
            {
                var frag = GalleryImageFragment.newInstance(imageIds[i])
                fragmentsList.add(frag)
            }
        }

        override fun getItem(position: Int): Fragment = fragmentsList[position]

        override fun getCount() = fragmentsList.size

    }
}
