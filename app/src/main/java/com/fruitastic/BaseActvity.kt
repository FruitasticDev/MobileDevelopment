package com.fruitastic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.lifecycleScope
import com.fruitastic.data.pref.AppPreferences
import com.fruitastic.data.pref.dataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        applyThemeSetting()
    }

    private fun applyThemeSetting() {
        lifecycleScope.launch {
            val isDarkModeActive = AppPreferences.getInstance(application.dataStore)
                .getThemeSetting().first()

            if (isDarkModeActive) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }
}
