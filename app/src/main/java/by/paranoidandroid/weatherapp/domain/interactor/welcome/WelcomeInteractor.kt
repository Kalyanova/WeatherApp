package by.paranoidandroid.weatherapp.domain.interactor.welcome

import by.paranoidandroid.weatherapp.domain.interactor.Interactor

interface WelcomeInteractor: Interactor {

    interface Callback {
        fun onRetrieve(message: String)
        fun onFailed(error: String)
    }
}