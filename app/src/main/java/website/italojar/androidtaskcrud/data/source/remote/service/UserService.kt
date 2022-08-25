package website.italojar.androidtaskcrud.data.source.remote.service

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import website.italojar.androidtaskcrud.common.RetrofitHelper
import website.italojar.androidtaskcrud.data.model.dto.UserDtoItem
import website.italojar.androidtaskcrud.data.model.dto.UsersDto
import website.italojar.androidtaskcrud.data.source.remote.interfaces.ApiClient
import website.italojar.androidtaskcrud.domain.repository.UserRepository

class UserService: UserRepository {

    private val retrofit = RetrofitHelper.getRetrofit()

    override suspend fun getUsers(): List<UserDtoItem> {
        return withContext(Dispatchers.IO) {
            val response: Response<UsersDto> =
                retrofit.create(ApiClient::class.java).getUsers()
            response.body() ?: emptyList()
        }
    }
}