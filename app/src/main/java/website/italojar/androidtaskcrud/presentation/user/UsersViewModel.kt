package website.italojar.androidtaskcrud.presentation.user

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import website.italojar.androidtaskcrud.domain.mappers.toUser
import website.italojar.androidtaskcrud.domain.model.User
import website.italojar.androidtaskcrud.domain.usecase.GetUsersUseCase
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
): ViewModel() {

    val users = MutableLiveData<List<User>>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getUsersUseCase()

            if (!result.isNullOrEmpty()) {
                users.postValue(result)
                isLoading.postValue(false)
            }
        }
    }

    fun users() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getUsersUseCase()
            if (!result.isNullOrEmpty()) {
                users.postValue(result)
                isLoading.postValue(false)
            }
        }
    }
}