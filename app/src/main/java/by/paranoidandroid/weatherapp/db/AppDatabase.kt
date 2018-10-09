package by.paranoidandroid.weatherapp.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.Room
import android.content.Context
import by.paranoidandroid.weatherapp.db.dao.CityDao
import by.paranoidandroid.weatherapp.db.entity.City

@Database(entities = [City::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        private const val DATABASE_NAME = "cities.db"
        var INSTANCE: AppDatabase? = null

        fun getAppDatabase(context: Context): AppDatabase? {
            if (INSTANCE == null){
                synchronized(AppDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                                                    AppDatabase::class.java,
                                                    DATABASE_NAME)
                                    //.allowMainThreadQueries()
                                    .build()
                }
            }
            return INSTANCE
        }

        /*fun destroyDataBase(){
            INSTANCE = null
        }*/
    }

    abstract fun cityDao(): CityDao
}