package com.wajahatkarim3.easyflipviewpager.demo

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class GalleryImageFragment : Fragment() {

    internal var imageId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            imageId = it.getInt("imageId", R.drawable.ic_launcher_background)

        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        if(imageId != null)
        {
            val rootView = inflater.inflate(R.layout.fragment_gallery_page_layout, container, false)

            val imageView = rootView.findViewById<ImageView>(R.id.imageView)

            imageView.setImageResource(imageId)
            return rootView
        }
        else {
            val rootView = inflater.inflate(R.layout.fragment_demo_layout, container, false)

            val imageView = rootView.findViewById<ImageView>(R.id.imageView)
            val btnLaunch = rootView.findViewById<Button>(R.id.btnLaunch)

            imageView.setImageResource(imageId)
            btnLaunch.setOnClickListener {
                when(imageId)
                {
                    R.drawable.books_snap -> startActivity(Intent(context, BookOnboardingActivity::class.java))
                    R.drawable.gallery_snap -> startActivity(Intent(context, PictureGalleryDemoActivity::class.java))
                    R.drawable.poker_snap -> startActivity(Intent(context, PokerCardDemoActivity::class.java))
                    R.drawable.viewpager2_snap -> startActivity(Intent(context, ViewPager2DemoActivity::class.java))
                }
            }

            return rootView
        }
    }

    companion object {
        fun newInstance(imageId: Int): GalleryImageFragment
        {
            val fragment = GalleryImageFragment()
            val args = Bundle()

            args.putInt("imageId", imageId)
            fragment.arguments = args
            return fragment
        }
    }


}