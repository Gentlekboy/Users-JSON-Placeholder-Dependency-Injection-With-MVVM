package com.gentlekboy.dependencyinjectionclasswork

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.gentlekboy.dependencyinjectionclasswork.databinding.ActivityMainBinding
import com.gentlekboy.dependencyinjectionclasswork.viewModel.UsersViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val usersViewModel: UsersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getUsers()
    }

    /*
    This function triggers the get request
    It also observes the live data in the view model and updates the UI accordingly
     */
    private fun getUsers(){
        usersViewModel.getUsersIntoViewModel()
        usersViewModel.liveDataOfUsers.observe(this, {
            if (it.isSuccessful){
                Log.d("GKB", "getUsers: ${it.body()}")
            }else{
                Log.d("GKB", "getUsers: ${it.code()}")
                Log.d("GKB", "getUsers: ${it.message()}")
            }
        })
    }
}