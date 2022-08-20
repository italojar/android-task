package website.italojar.androidtaskcrud.domain.usecase

import website.italojar.androidtaskcrud.domain.mappers.toUser
import website.italojar.androidtaskcrud.domain.model.User
import website.italojar.androidtaskcrud.domain.repository.UserRepository
import javax.inject.Inject

class GetUsersUseCase  @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke():List<User>{
        val users = repository.getUsers()

        return if(users.isNotEmpty()){
            users.map { userDto -> userDto.toUser() }
        }else{
            emptyList()
        }
    }
}