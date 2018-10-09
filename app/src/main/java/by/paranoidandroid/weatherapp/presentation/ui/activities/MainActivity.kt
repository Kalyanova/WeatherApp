package by.paranoidandroid.weatherapp.presentation.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import by.paranoidandroid.weatherapp.R
import by.paranoidandroid.weatherapp.db.WelcomeRepositoryDB
import by.paranoidandroid.weatherapp.domain.executor.impl.ThreadExecutor
import by.paranoidandroid.weatherapp.presentation.thread.MainThreadImpl
import by.paranoidandroid.weatherapp.presenter.impl.welcome.WelcomePresenterImpl
import by.paranoidandroid.weatherapp.presenter.welcome.WelcomePresenter

class MainActivity : AppCompatActivity(),
                     WelcomePresenter.WelcomeView {

    lateinit var presenter: WelcomePresenter
    var tvWelcomeMessage: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvWelcomeMessage = findViewById(R.id.tv_welcome_message)
        presenter = WelcomePresenterImpl(
                ThreadExecutor,
                MainThreadImpl,
                this,
                WelcomeRepositoryDB()
        )
    }

    override fun onResume() {
        super.onResume()
        presenter.resume()
    }

    override fun displayWelcomeMessage(message: String) {
        tvWelcomeMessage?.text = message
    }
}