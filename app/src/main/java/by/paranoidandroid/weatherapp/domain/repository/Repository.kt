package by.paranoidandroid.weatherapp.domain.repository

/**
 * A sample repository with CRUD operations on a model.
 */
interface Repository {
    fun get(id: Any): Any

    fun insert(model: Any)

    fun delete(model: Any)

    fun update(model: Any)
}