package by.paranoidandroid.weatherapp.domain.interactor.impl.welcome

import by.paranoidandroid.weatherapp.domain.executor.MainThread
import by.paranoidandroid.weatherapp.domain.executor.impl.ThreadExecutor
import by.paranoidandroid.weatherapp.domain.interactor.AbstractInteractor
import by.paranoidandroid.weatherapp.domain.interactor.welcome.WelcomeInteractor
import by.paranoidandroid.weatherapp.domain.repository.welcome.WelcomeRepository

class WelcomeInteractorImpl(threadExecutor: ThreadExecutor,
                            mainThread: MainThread,
                            val repository: WelcomeRepository,
                            val callback: WelcomeInteractor.Callback) : AbstractInteractor(threadExecutor, mainThread), WelcomeInteractor {
    private val errorMsg = "Failed to retrieve message from database!"

    override fun run() {
        val message: String? = repository.getWelcomeMessage()
        if (message != null) {
            mainThread.post{ callback.onRetrieve(message) }
        }
        else {
            mainThread.post{ callback.onFailed(errorMsg) }
        }
    }
}