package website.italojar.androidtaskcrud.presentation.users.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import website.italojar.androidtaskcrud.R
import website.italojar.androidtaskcrud.databinding.UserItemBinding
import website.italojar.androidtaskcrud.domain.model.User

class UserAdapter(
private val values: List<User>,
private val onClick : (user: User) -> Unit
): RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.user_item, parent, false )
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.render(values[position])
        holder.itemView.setOnClickListener { onClick(values[position]) }
    }

    override fun getItemCount() = values.size

    inner class UserViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val userItem = UserItemBinding.bind(view)
        fun render(user: User) {
            userItem.userId.text = user.id.toString()
            userItem.userName.text = user.name
            userItem.userBirthday.text = user.birthdate
        }
    }
}