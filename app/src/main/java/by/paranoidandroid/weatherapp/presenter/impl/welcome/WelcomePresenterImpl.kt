package by.paranoidandroid.weatherapp.presenter.impl.welcome

import by.paranoidandroid.weatherapp.domain.executor.MainThread
import by.paranoidandroid.weatherapp.domain.executor.impl.ThreadExecutor
import by.paranoidandroid.weatherapp.domain.interactor.impl.welcome.WelcomeInteractorImpl
import by.paranoidandroid.weatherapp.domain.interactor.welcome.WelcomeInteractor
import by.paranoidandroid.weatherapp.domain.repository.welcome.WelcomeRepository
import by.paranoidandroid.weatherapp.presenter.welcome.WelcomePresenter

class WelcomePresenterImpl(val threadExecutor: ThreadExecutor,
                           val mainThread: MainThread,
                           val view: WelcomePresenter.WelcomeView,
                           val repository: WelcomeRepository) : WelcomePresenter,
                                                                WelcomeInteractor.Callback{

    override fun onRetrieve(message: String) {
        view.hideProgress()
        view.displayWelcomeMessage(message)
    }

    override fun onFailed(error: String) {
        view.hideProgress()
        view.showError(error)
    }

    override fun resume() {
        view.showProgress()
        val interactor = WelcomeInteractorImpl(
                threadExecutor,
                mainThread,
                repository,
                this
        )
        interactor.execute()
    }
}