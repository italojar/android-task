package website.italojar.androidtaskcrud.domain.usecase

import website.italojar.androidtaskcrud.data.repository.UsersRepositoryImpl
import website.italojar.androidtaskcrud.domain.mappers.toUser
import website.italojar.androidtaskcrud.domain.model.User
import website.italojar.androidtaskcrud.domain.repository.UserRepository
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val repository: UsersRepositoryImpl
) {

    suspend operator fun invoke():List<User>{
        val users = repository.getUsers()

        return if(users.isNotEmpty()){
            users.map { userDto ->
                val name = userDto.name ?: "Unknow username"
                userDto.toUser(name)
            }
        }else{
            emptyList()
        }
    }
}