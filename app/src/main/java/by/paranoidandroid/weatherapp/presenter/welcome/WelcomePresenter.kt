package by.paranoidandroid.weatherapp.presenter.welcome

import by.paranoidandroid.weatherapp.presentation.ui.View
import by.paranoidandroid.weatherapp.presenter.Presenter

interface WelcomePresenter : Presenter {

    interface WelcomeView : View {
        fun displayWelcomeMessage(message: String)
    }
}