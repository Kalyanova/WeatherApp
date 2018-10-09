package by.paranoidandroid.weatherapp.db.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "city")
data class City(@PrimaryKey(autoGenerate = true)
                val id: Int,
                val name: String)