package com.example.language1

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.RadioButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.language1.RvAdapter
import com.example.language1.OutData
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var languageAdapter: RvAdapter
    private lateinit var recyclerView: RecyclerView
    private var selectedLanguage = "English"

    private fun updateSelectedLanguage(newLocale: Locale) {
        Locale.setDefault(newLocale)
        val config = Configuration()
        config.setLocale(newLocale)
        resources.updateConfiguration(config, resources.displayMetrics)

        this.recreate()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rvlanguage)
        languageAdapter = RvAdapter(languagelist)
        recyclerView.adapter = languageAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)


        val radioButton1: RadioButton = findViewById(R.id.bt1)
        val radioButton2: RadioButton = findViewById(R.id.bt2)
        val radioButton3: RadioButton = findViewById(R.id.bt3)
        val radioButton4: RadioButton = findViewById(R.id.bt4)
        val radioButton5: RadioButton = findViewById(R.id.bt5)
        val doneButton: ImageButton = findViewById(R.id.selectButton)



//        radioButton1.setOnClickListener{
//            selectedLanguage = "English"
//        }
//        radioButton2.setOnClickListener{
//            selectedLanguage = "Spanish"
//        }
//        radioButton3.setOnClickListener{
//            selectedLanguage = "French"
//        }
//        radioButton4.setOnClickListener{
//            selectedLanguage = "Hindi"
//        }
//        radioButton5.setOnClickListener{
//            selectedLanguage = "Protuguese"
//        }

        doneButton.setOnClickListener {
            val newLocale = when {
                radioButton1.isChecked -> {
                    Locale("en")
                }
                radioButton2.isChecked -> {
                    Locale("es")
                }
                radioButton3.isChecked -> {
                    Locale("fr")
                }
                radioButton4.isChecked -> {
                    Locale("hi")
                }
                radioButton5.isChecked -> {
                    Locale("pt")
                }
                else -> {
                    Locale("en")
                }
            }

            updateSelectedLanguage(newLocale)

            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            finish()
        }

    }
    }

    private val languagelist = listOf(
        OutData("English", R.drawable.english_flag),
        OutData("Spanish", R.drawable.spain_flag),
        OutData("French", R.drawable.france_flag),
        OutData("Hindi", R.drawable.hindi_flag),
        OutData("Portugeese", R.drawable.portugal_flag),
    )

