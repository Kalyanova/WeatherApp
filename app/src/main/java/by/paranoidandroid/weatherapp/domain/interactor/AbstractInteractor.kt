package by.paranoidandroid.weatherapp.domain.interactor

import by.paranoidandroid.weatherapp.domain.executor.MainThread
import by.paranoidandroid.weatherapp.domain.executor.impl.ThreadExecutor

/**
 * This abstract class implements some common methods for all interactors. Cancelling an interactor, check if its running
 * and finishing an interactor has mostly the same code throughout so that is why this class was created. Field methods
 * are declared volatile as we might use these methods from different threads (mainly from UI).
 *
 * For example, when an activity is getting destroyed then we should probably cancel an interactor
 * but the request will come from the UI thread unless the request was specifically assigned to a background thread.
 */
abstract class AbstractInteractor(val threadExecutor: ThreadExecutor,
                                  val mainThread: MainThread) : Interactor {
    @Volatile private var isRunning = false
    @Volatile private var isCancelled = false

    /**
     * This method contains the actual business logic of the interactor. It SHOULD NOT BE USED DIRECTLY but, instead, a
     * developer should call the execute() method of an interactor to make sure the operation is done on a background thread.
     *
     * This method should only be called directly while doing unit/integration tests. That is the only reason it is declared
     * public as to help with easier testing.
     */
    abstract fun run()

    fun cancel() {
        isRunning = false
        isCancelled = false
    }

    fun isRunning() = isRunning

    fun onFinish() {
        isRunning = false
        isCancelled = false
    }

    override fun execute() {
        isRunning = true

        // start running this interactor in a background thread
        threadExecutor.execute(this)
    }

}