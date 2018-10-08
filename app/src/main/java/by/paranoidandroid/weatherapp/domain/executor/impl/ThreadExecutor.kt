package by.paranoidandroid.weatherapp.domain.executor.impl

import by.paranoidandroid.weatherapp.domain.executor.Executor
import by.paranoidandroid.weatherapp.domain.interactor.AbstractInteractor
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

/**
 * This singleton class will make sure that each interactor operation gets a background thread.
 */
object ThreadExecutor: Executor {
    private val threadPoolExecutor: ThreadPoolExecutor
    private const val CORE_POOL = 5
    private const val MAX_POOL = 5
    private const val KEEP_ALIVE = 120L
    private val queue: BlockingQueue<Runnable>

    init {
        queue = LinkedBlockingQueue<Runnable>()
        threadPoolExecutor = ThreadPoolExecutor(CORE_POOL, MAX_POOL, KEEP_ALIVE, TimeUnit.SECONDS, queue)
    }

    override fun execute(interactor: AbstractInteractor) {
        threadPoolExecutor.submit {
            interactor.run()
            interactor.onFinish()
        }
    }

}