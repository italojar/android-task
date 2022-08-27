package website.italojar.androidtaskcrud.data.source.local

import website.italojar.androidtaskcrud.data.model.dto.UserDtoItem
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UsersProvider @Inject constructor() {

    var getUsers = emptyList<UserDtoItem>()
}