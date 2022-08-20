package website.italojar.androidtaskcrud.data.datasource.remote.interfaces

import retrofit2.http.GET
import website.italojar.androidtaskcrud.data.datasource.remote.dto.UserDto

interface HelloWorldApi {

    @GET("/api/User")
    suspend fun getUsers(): List<UserDto>
}