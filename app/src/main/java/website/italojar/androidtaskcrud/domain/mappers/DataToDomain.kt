package website.italojar.androidtaskcrud.domain.mappers

import website.italojar.androidtaskcrud.data.model.dto.UserDtoItem
import website.italojar.androidtaskcrud.domain.model.User

fun UserDtoItem.toUser(name: String) = User(
        birthdate = this.birthdate,
        id = this.id,
        name = name
    )