package by.paranoidandroid.weatherapp

import android.app.Application
import by.paranoidandroid.weatherapp.db.AppDatabase

class AndroidApplication : Application() {
    companion object {
        lateinit var instance: AndroidApplication
            private set
    }

    var database: AppDatabase? = null

    override fun onCreate() {
        super.onCreate()
        instance = this

        database = AppDatabase.getAppDatabase(this)

        // only for the sake of test
        /*database?.cityDao()?.insertAll(City(1, "Moscow"),
                                       City(2, "Minsk"))*/
    }
}