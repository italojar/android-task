package website.italojar.androidtaskcrud.presentation.users

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import website.italojar.androidtaskcrud.domain.model.User
import website.italojar.androidtaskcrud.domain.usecase.GetUsersUseCase
import javax.inject.Inject

class UsersViewModel: ViewModel() {

    private val getUsersUseCase = GetUsersUseCase()
    val usersModel = MutableLiveData<List<User>>()
    val isLoading = MutableLiveData<Boolean>()

    init {
        getUsers()
    }

    fun getUsers() {
        viewModelScope.launch {
            val users = getUsersUseCase()
            if (!users.isNullOrEmpty()){
                usersModel.value = users
            }
        }
    }

    fun updateUsers(users: MutableList<User>) {
        viewModelScope.launch { usersModel.postValue(users) }
    }
}