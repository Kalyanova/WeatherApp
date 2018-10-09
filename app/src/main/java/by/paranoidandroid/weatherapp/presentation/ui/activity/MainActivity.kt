package by.paranoidandroid.weatherapp.presentation.ui.activity

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.widget.ContentLoadingProgressBar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import by.paranoidandroid.weatherapp.R
import by.paranoidandroid.weatherapp.db.WelcomeRepositoryDB
import by.paranoidandroid.weatherapp.db.parseCities
import by.paranoidandroid.weatherapp.db.parseFile
import by.paranoidandroid.weatherapp.domain.executor.impl.ThreadExecutor
import by.paranoidandroid.weatherapp.presentation.thread.MainThreadImpl
import by.paranoidandroid.weatherapp.presenter.impl.welcome.WelcomePresenterImpl
import by.paranoidandroid.weatherapp.presenter.welcome.WelcomePresenter

class MainActivity : AppCompatActivity(),
                     WelcomePresenter.WelcomeView {

    lateinit var presenter: WelcomePresenter
    var tvWelcomeMessage: TextView? = null
    var progressBar: ContentLoadingProgressBar? = null
    var bottomNavView: BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvWelcomeMessage = findViewById(R.id.tv_welcome_message)
        progressBar = findViewById(R.id.progress_bar)
        bottomNavView = findViewById(R.id.bottom_nav_view)

        presenter = WelcomePresenterImpl(
                ThreadExecutor,
                MainThreadImpl,
                this,
                WelcomeRepositoryDB()
        )

        // TODO: remove this - this is just for the sake of test
        parseCities(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.resume()
    }

    override fun displayWelcomeMessage(message: String) {
        tvWelcomeMessage?.text = message
    }

    override fun showProgress() {
        progressBar?.show()
    }

    override fun hideProgress() {
        progressBar?.hide()
    }
}