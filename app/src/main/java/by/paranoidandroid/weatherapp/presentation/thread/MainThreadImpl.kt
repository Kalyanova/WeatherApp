package by.paranoidandroid.weatherapp.presentation.thread

import android.os.Handler
import android.os.Looper
import by.paranoidandroid.weatherapp.domain.executor.MainThread

/**
 * This class makes sure that the runnable we provide will be run on the main UI thread.
 */
object MainThreadImpl : MainThread {
    private val handler: Handler

    init {
        handler = Handler(Looper.getMainLooper())
    }

    override fun post(runnable: () -> Unit) {
        handler.post(runnable)
    }
}