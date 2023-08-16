package com.example.intro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.languagetp.R

class MainActivity2 : AppCompatActivity() {

    private lateinit var languageAdapter: LanguageAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.rvLanguge)
        languageAdapter = LanguageAdapter(languagelist)
        recyclerView.adapter = languageAdapter
    }

    val languagelist = listOf<Outdata>(
        Outdata("English",R.drawable.english_flag),
        Outdata("Spanish",R.drawable.spain_flag),
        Outdata("French",R.drawable.france_flag),
        Outdata("Hindi",R.drawable.hindi_flag),
        Outdata("Poturgeese",R.drawable.portugal_flag),

        )
}