package website.italojar.androidtaskcrud.presentation.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import website.italojar.androidtaskcrud.domain.model.User
import website.italojar.androidtaskcrud.domain.usecase.GetUsersUseCase

class UsersViewModel: ViewModel() {

    private val getUsersUseCase = GetUsersUseCase()
    private val _usersModel = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> = _usersModel
    val isLoading = MutableLiveData<Boolean>()

    init {
        getUsers()
    }

    private fun getUsers() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val users = getUsersUseCase()
            if (!users.isNullOrEmpty()){
                _usersModel.value = users
                isLoading.postValue(false)
            }
        }
    }

    fun updateUsers(users: MutableList<User>) {
        viewModelScope.launch { _usersModel.postValue(users) }
    }
}