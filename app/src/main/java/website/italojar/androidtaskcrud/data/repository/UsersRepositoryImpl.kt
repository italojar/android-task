package website.italojar.androidtaskcrud.data.repository

import website.italojar.androidtaskcrud.data.model.dto.UserDtoItem
import website.italojar.androidtaskcrud.data.source.local.UsersProvider
import website.italojar.androidtaskcrud.data.source.remote.service.UserService
import website.italojar.androidtaskcrud.domain.repository.UserRepository

class UsersRepositoryImpl: UserRepository {

    private val api = UserService()

    override suspend fun getUsers(): List<UserDtoItem> {
        val response:List<UserDtoItem> = api.getUsers()
        UsersProvider().getUsers = response
        return response
    }
}