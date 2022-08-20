package website.italojar.androidtaskcrud.domain.repository

import website.italojar.androidtaskcrud.data.datasource.remote.dto.UserDto

interface UserRepository {

    suspend fun getUsers(): List<UserDto>
}