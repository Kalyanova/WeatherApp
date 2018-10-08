package by.paranoidandroid.weatherapp.domain.interactor

/**
 * This is the main interface of an interactor. Each interactor serves a specific use case.
 * This interface shoulld be used only in this package
 */
interface Interactor {

    /**
     * This is the main method that starts an interactor. It will make sure that the interactor operation is done on a
     * background thread.
     */
    fun execute()
}