package com.ekyc.multilanguagesupport

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ekyc.multilanguagesupport.databinding.ActivityLanguageBinding

class LanguageActivity : AppCompatActivity() {
    private lateinit var languageBinding: ActivityLanguageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        languageBinding = ActivityLanguageBinding.inflate(layoutInflater)
        setContentView(languageBinding.root)
        getDefaultLanguage()
        languageBinding.btnEnglish.setOnClickListener {
            saveLanguagePreference("en")
        }

        languageBinding.btnHindi.setOnClickListener {
            saveLanguagePreference("hi")
        }
        languageBinding.btnTamil.setOnClickListener {
            saveLanguagePreference("ta")
        }
        languageBinding.btnOdiya.setOnClickListener {
            saveLanguagePreference("or")
        }
        languageBinding.btnGujurati.setOnClickListener {
            saveLanguagePreference("gu")
        }
        languageBinding.btnSpanish.setOnClickListener {
            saveLanguagePreference("es")
        }

    }

    private fun saveLanguagePreference(lang: String) {
        val sharedPreferences = getSharedPreferences("LANGUAGE_PREF", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("LANGUAGE", lang).apply()
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("LANGUAGE", lang)
        startActivity(intent)
    }

    private fun getDefaultLanguage() {
        val sharedPreferences = getSharedPreferences("LANGUAGE_PREF", MODE_PRIVATE)
        if (sharedPreferences.contains("LANGUAGE")) {
            val lang = sharedPreferences.getString("LANGUAGE", "en")
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("LANGUAGE", lang)
            startActivity(intent)
        } else {

        }
    }
}