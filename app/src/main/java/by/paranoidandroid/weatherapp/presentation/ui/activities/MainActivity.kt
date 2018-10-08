package by.paranoidandroid.weatherapp.presentation.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import by.paranoidandroid.weatherapp.R
import by.paranoidandroid.weatherapp.presentation.ui.View

class MainActivity : AppCompatActivity(), View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}