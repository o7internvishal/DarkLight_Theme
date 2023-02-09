package com.example.darklight_theme


import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.example.darklight_theme.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    val TAG = this.javaClass.simpleName

    var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val currentNightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        when (currentNightMode) {
            Configuration.UI_MODE_NIGHT_NO -> {
                Log.e(TAG, "in Light Mode")
                binding?.switch1?.text="Enable Dark Mode"
                binding?.switch1?.isChecked = false
            } // Night mode is not active, we're using the light theme.
            Configuration.UI_MODE_NIGHT_YES -> {
                Log.e(TAG, "in Night Mode")
                binding?.switch1?.isChecked = true
                binding?.switch1?.text="Disable Dark mode"

            } // Night mode is active, we're using dark theme.
        }

        binding?.switch1?.setOnCheckedChangeListener{ _, isChecked ->
//            Toast.makeText(this, "Switch Button", Toast.LENGTH_LONG).show()
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                binding?.switch1?.text="Disable Dark mode"
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                this.finish()
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                binding?.switch1?.text="Enable Dark Mode"
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                this.finish()
            }

            val currentNightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
            when (currentNightMode) {
                Configuration.UI_MODE_NIGHT_NO -> {
                    Log.e(TAG, "in Light Mode")
                } // Night mode is not active, we're using the light theme.
                Configuration.UI_MODE_NIGHT_YES -> {
                    Log.e(TAG, "in Night Mode")
                } // Night mode is active, we're using dark theme.
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}