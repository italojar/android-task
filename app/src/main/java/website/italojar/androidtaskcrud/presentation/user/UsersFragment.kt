package website.italojar.androidtaskcrud.presentation.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import website.italojar.androidtaskcrud.databinding.FragmentUsersBinding
import website.italojar.androidtaskcrud.domain.model.User
import website.italojar.androidtaskcrud.presentation.user.adapters.UserAdapter

@AndroidEntryPoint
class UsersFragment : Fragment() {

    private var _binding: FragmentUsersBinding? = null
    private val binding get() = _binding!!
    private val viewModel: UsersViewModel by viewModels()

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
        viewModel.onCreate()
        viewModel.users.observe(this, Observer {
            initRecyclerViewOtes(it)
        })
    }

    private fun initRecyclerViewOtes(listUsers: List<User>){
        binding.rvUsers.layoutManager = LinearLayoutManager(requireContext())
        val userAdapter = UserAdapter(listUsers){ user ->
            Toast.makeText(requireContext(), user.name, Toast.LENGTH_SHORT).show()
        }
        binding.rvUsers.adapter = userAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}