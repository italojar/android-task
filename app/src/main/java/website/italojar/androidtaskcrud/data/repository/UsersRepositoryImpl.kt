package website.italojar.androidtaskcrud.data.repository

import website.italojar.androidtaskcrud.data.model.dto.UserDtoItem
import website.italojar.androidtaskcrud.data.source.local.UsersProvider
import website.italojar.androidtaskcrud.data.source.remote.service.UserService
import website.italojar.androidtaskcrud.domain.repository.UserRepository
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(
    private val api: UserService,
    private val usersProvider: UsersProvider
)  : UserRepository {

    override suspend fun getUsers(): List<UserDtoItem> {
        val response:List<UserDtoItem> = api.getUsers()
        usersProvider.getUsers = response
        return response
    }
}