package by.paranoidandroid.weatherapp.db

import by.paranoidandroid.weatherapp.AndroidApplication
import by.paranoidandroid.weatherapp.domain.repository.welcome.WelcomeRepository

class WelcomeRepositoryDB : WelcomeRepository {

    override fun getWelcomeMessage(): String {
        val msg = "Welcome!"

        // to simulate some network/database lag
        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        val db = AndroidApplication.instance.database
        val city = db?.cityDao()?.get(1)

        return city?.name?:msg
    }
}