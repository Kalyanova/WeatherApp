package by.paranoidandroid.weatherapp.domain.model

data class City(val id: Int,
                val name: String,
                val country: String,
                val lon: Int,
                val lat: Int,
                val iconUrl: String)