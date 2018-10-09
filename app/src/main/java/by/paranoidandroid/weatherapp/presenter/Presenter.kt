package by.paranoidandroid.weatherapp.presenter

/**
 * Method that control the lifecycle of the view. It's methods should be called in the view's
 * (Activity or Fragment) appropriate methods.
 */
interface Presenter {
    companion object {
        val TAG = "Presenter"
    }

    fun resume() {}

    fun pause() {}

    fun stop() {}

    fun destroy() {}

    fun onError(message: String) {}




}