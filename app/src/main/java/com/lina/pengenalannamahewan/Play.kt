package com.lina.pengenalannamahewan

import android.app.Activity
import android.media.MediaPlayer
import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ScrollingView
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView

class Play() : AppCompatActivity() {
    lateinit var pager: ViewPager
    internal var nama = arrayOf(
        "Singa",
        "Monyet",
        "Gajah")
    internal var gambar = intArrayOf(R.drawable.singa, R.drawable.monyet, R.drawable.gajah)
    internal var suara = intArrayOf(R.raw.singa, R.raw.monyet, R.raw.gajah)
    lateinit var adapter: PagerAdapter
    internal var mp: MediaPlayer? = null

    var onPage: ViewPager.OnPageChangeListener = object : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(p0: Int) {
        }

        override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
        }

        override fun onPageSelected(p0: Int) {
            if (mp != null) {
                mp!!.reset()
                mp!!.release()
            }
            mp = MediaPlayer.create(this@Play, suara[p0])
            mp!!.start()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_play)
        pager = findViewById(R.id.viewpager) as ViewPager
//        pager = findViewById(R.id.viewpager) as ViewPager
        adapter = GambarAdapter(this, gambar,nama)

        pager.adapter = adapter
        pager.setOnPageChangeListener(onPage)
    }
    class GambarAdapter(play: Play, internal var gambar: IntArray,
                        internal var nama: Array<String>) : PagerAdapter() {
        lateinit var inflater: LayoutInflater
        internal var activity: Activity

        init {
            this.activity = play
        }

        override fun getCount(): Int {
            return gambar.size
        }

        override fun isViewFromObject(p0: View, p1: Any): Boolean {
            return p0 === p1 as ScrollView
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            inflater = activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val tampil = inflater.inflate(R.layout.item_view_pager, container, false)
            val img = tampil.findViewById(R.id.imgbinatang) as ImageView
            val text = tampil.findViewById(R.id.textbinatang) as TextView
            img.setImageResource(gambar[position])
            text.text = nama[position]
            (container as ViewPager).addView(tampil)
            return tampil
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any){
            (container as ViewPager).removeView(`object` as ScrollView)
        }
    }
}



//selesaikan class gambaradapter sampai fungsigetCount dan isViewFromObject dulu
//class GambarAdapter(play: Play, internal var gambar: IntArray, internal var nama: Array<String>) : PagerAdapter() {
//    lateinit var inflater: LayoutInflater
//    internal var activity: Activity
//
//    init {
//        this.activity = play
//    }
//
//    override fun getCount(): Int {
//        return gambar.size
//    }
//
//    override fun isViewFromObject(p0: View, p1: Any): Boolean {
//        return p0 === p1 as ScrollingView
//    }
//
//    override fun instantiateItem(container: ViewGroup, position: Int): Any {
//        inflater = activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//        val tampil = inflater.inflate(R.layout.item_view_pager, container, false)
//        val img = tampil.findViewById(R.id.imgbinatang) as ImageView
//        img.setImageResource(gambar[position])
//        text.text = nama[position]
//        (container as ViewPager).addView(tampil)
//    }
//
//    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any){
//        (container as ViewPager).removeView(`object` as ScrollingView)
//    }
//
//
//}

