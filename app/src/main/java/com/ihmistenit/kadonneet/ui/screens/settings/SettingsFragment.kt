package com.ihmistenit.kadonneet.ui.screens.settings

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.ListPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.ihmistenit.kadonneet.R

class SettingsFragment : PreferenceFragmentCompat() {
    fun evaluateThemePreference(newVal: Any): Boolean {
        if (newVal == "auto") AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        if (newVal == "day") AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        if (newVal == "night") AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

        return true
    }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        preferenceManager.findPreference<ListPreference>("theme")
            ?.setOnPreferenceChangeListener { _: Preference, newVal: Any -> evaluateThemePreference(newVal) }
    }
}