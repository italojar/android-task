package website.italojar.androidtaskcrud.data.source.remote.interfaces

import retrofit2.Response
import retrofit2.http.GET
import website.italojar.androidtaskcrud.data.model.dto.UsersDto

interface ApiClient {

    @GET("api/User")
    suspend fun getUsers(): Response<UsersDto>
}