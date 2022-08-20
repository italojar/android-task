package website.italojar.androidtaskcrud.presentation.user

import website.italojar.androidtaskcrud.domain.model.User

data class UserListState(
    val isLoading: Boolean = false,
    val users: List<User> = emptyList(),
    val error: String = ""
)
