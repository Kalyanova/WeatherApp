package by.paranoidandroid.weatherapp.domain.executor

import by.paranoidandroid.weatherapp.domain.interactor.AbstractInteractor
import by.paranoidandroid.weatherapp.domain.interactor.Interactor

/**
 * This executor is responsible for running interactors on background threads.
 */
interface Executor {

    /**
     * This method should call the interactor's run method and thus start the interactor. This should be called
     * on a background thread as interactors might do lengthy operations.
     *
     * @param interactor The interactor to run.
     */
    fun execute(interactor: AbstractInteractor)
}
