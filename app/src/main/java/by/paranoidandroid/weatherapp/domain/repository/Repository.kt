package by.paranoidandroid.weatherapp.domain.repository

import by.paranoidandroid.weatherapp.domain.model.SimpleModel

/**
 * A sample repository with CRUD operations on a model.
 */
interface Repository {
    fun get(id: Any): SimpleModel

    fun insert(model: SimpleModel)

    fun delete(model: SimpleModel)

    fun update(model: SimpleModel)
}