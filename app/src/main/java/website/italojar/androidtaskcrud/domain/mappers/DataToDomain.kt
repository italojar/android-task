package website.italojar.androidtaskcrud.domain.mappers

import website.italojar.androidtaskcrud.data.datasource.remote.dto.UserDto
import website.italojar.androidtaskcrud.domain.model.User

fun UserDto.toUser() = User(
    birthdate = this.birthdate,
    name = this.name,
    id = this.id
)