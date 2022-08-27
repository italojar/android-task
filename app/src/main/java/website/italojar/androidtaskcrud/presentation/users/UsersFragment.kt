package website.italojar.androidtaskcrud.presentation.users

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import website.italojar.androidtaskcrud.databinding.FragmentUsersBinding
import website.italojar.androidtaskcrud.domain.model.User
import website.italojar.androidtaskcrud.presentation.users.adapters.UserAdapter
import website.italojar.androidtaskcrud.presentation.users.interfaces.IUsersListener

@AndroidEntryPoint
class UsersFragment : Fragment(), IUsersListener {

    private var _binding: FragmentUsersBinding? = null
    private val binding get() = _binding!!

    private val viewModel: UsersViewModel by viewModels()
    private val linearLayoutManager = LinearLayoutManager(context)
    private lateinit var usersMutableList: MutableList<User>
    private lateinit var userAdapter: UserAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentUsersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.users.observe(this, Observer { users ->
            usersMutableList = users as MutableList<User>
            initRecyclerView()
        })
        viewModel.isLoading.observe(this, Observer { visibility ->
            binding.progressBar.root.isVisible = visibility
        })
        binding.btnAddUser.setOnClickListener { addUser() }
    }

    private fun initRecyclerView(){
        userAdapter = UserAdapter(values = usersMutableList, listeners = this)
        binding.rvUsers.layoutManager = linearLayoutManager
        binding.rvUsers.adapter = userAdapter
    }

    private fun addUser() {
        if (!this::usersMutableList.isInitialized){
            usersMutableList = mutableListOf(
                User("1971-08-15T13:24:00", 5478, "New user")
            )
            initRecyclerView()
        }else {
            val user =  User("1971-08-15T13:24:00", 5478, "New user")
            usersMutableList.add(0, user)
            userAdapter.notifyItemInserted(0)
            linearLayoutManager.scrollToPositionWithOffset(0, 8)
        }
        viewModel.updateUsers(usersMutableList)
    }

    override fun onDeleteUser(position: Int) {
        usersMutableList.removeAt(position)
        userAdapter.notifyItemRemoved(position)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}