package by.paranoidandroid.weatherapp.domain.interactor.impl.welcome

import by.paranoidandroid.weatherapp.domain.executor.MainThread
import by.paranoidandroid.weatherapp.domain.executor.impl.ThreadExecutor
import by.paranoidandroid.weatherapp.domain.interactor.welcome.WelcomeInteractor
import by.paranoidandroid.weatherapp.domain.repository.welcome.WelcomeRepository
import org.junit.Before
import org.junit.Test

class WelcomeInteractorImplTest {
    private lateinit var mainThread: FakeMainThread
    private lateinit var callback: FakeCallback
    private lateinit var repository: WelcomeRepository

    private class FakeMainThread : MainThread {
        override fun post(runnable: () -> Unit) {
            println("fake post on main thread")
        }
    }

    private class FakeCallback : WelcomeInteractor.Callback {

        override fun onRetrieve(message: String) {
            //println("""onRetrieve with message '$message'""")
        }

        override fun onFailed(error: String) {
           //println("""onFailed with error '$error'""")
        }
    }

    private class FakeRepository : WelcomeRepository {
        override fun getWelcomeMessage() = "Welcome message"
    }

    @Before
    fun onSetup() {
        println("setup")
        repository = FakeRepository()
        callback = FakeCallback()
        mainThread = FakeMainThread()
    }

    @Test
    @Throws(Exception::class)
    fun testWelcomeMessageFound() {
        val interactor = WelcomeInteractorImpl(
                ThreadExecutor,
                mainThread,
                repository,
                callback
        )
        interactor.run()
    }
}