package website.italojar.androidtaskcrud.data.repo

import website.italojar.androidtaskcrud.data.datasource.remote.dto.UserDto
import website.italojar.androidtaskcrud.data.datasource.remote.interfaces.HelloWorldApi
import website.italojar.androidtaskcrud.domain.repository.UserRepository
import javax.inject.Inject

class UserRepoImpl @Inject constructor(
    private val api: HelloWorldApi
): UserRepository {

    override suspend fun getUsers(): List<UserDto> {
        return api.getUsers()
    }
}