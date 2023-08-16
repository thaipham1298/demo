package com.example.language1

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class MainActivity2 : AppCompatActivity() {
    private lateinit var introSlideAdapter: IntroslideAdapter
    private lateinit var viewpager: ViewPager2
    private var position = 0
    private val viewPager: ViewPager2 by lazy { findViewById<ViewPager2>(R.id.viewPager) }
    private val backButton1: TextView by lazy { findViewById<TextView>(R.id.backButton1) }
    private val nextButton1: TextView by lazy { findViewById<TextView>(R.id.nextButton1) }
    private val dotsIndicator: DotsIndicator by lazy { findViewById<DotsIndicator>(R.id.dots_indicator) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        viewpager = findViewById(R.id.viewPager)
        introSlideAdapter = IntroslideAdapter(introSlide)
        viewpager.adapter = introSlideAdapter

        nextButton1.setOnClickListener {
            position = viewPager.currentItem
            if (position < introSlide.size) {
                position++
                viewPager.currentItem = position
            }
            if (position == introSlide.size) {
                Toast.makeText(this, "Hoàn Thành", Toast.LENGTH_SHORT).show()
            }
        }
        backButton1.setOnClickListener {
            position = viewPager.currentItem
            if (position < introSlide.size) {
                position--
                viewPager.currentItem = position
            }
        }
        dotsIndicator.attachTo(viewPager)
    }

    private val introSlide = listOf(
        IntroData(R.string.title_intro, R.drawable.frame_1),
        IntroData(R.string.title_intro, R.drawable.intro2),
        IntroData(R.string.title_intro, R.drawable.framintro3)
    )

}

