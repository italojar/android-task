package website.italojar.androidtaskcrud.domain.repository

import website.italojar.androidtaskcrud.data.model.dto.UserDtoItem

interface UserRepository {

    suspend fun getUsers(): List<UserDtoItem>
}