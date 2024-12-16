package com.ekyc.multilanguagesupport

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val lang = intent.getStringExtra("LANGUAGE")
        loadSelectedLanguage(lang)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

    }

    private fun loadSelectedLanguage(lang: String?) {
        //option-1
        //  AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags(lang))
       //option-2
        /*   val locale = Locale(lang)
           Locale.setDefault(locale)
           val configuration: Configuration = resources.configuration
           configuration.setLocale(locale)
           createConfigurationContext(configuration)*/

        // Change the locale dynamically
        val locale = Locale(lang)
        Locale.setDefault(locale)

        val config:Configuration = resources.configuration
        config.setLocale(locale)
        config.setLayoutDirection(locale)

        // Update configuration without recreating the activity
        resources.updateConfiguration(config, resources.displayMetrics)
    }
}