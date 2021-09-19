package com.gentlekboy.dependencyinjectionclasswork.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gentlekboy.dependencyinjectionclasswork.model.UserData
import com.gentlekboy.dependencyinjectionclasswork.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(private val repository: Repository): ViewModel() {
    val liveDataOfUsers: MutableLiveData<Response<UserData>> = MutableLiveData()

    //Save fetched users from the repository to livedata
    fun getUsersIntoViewModel(){
        viewModelScope.launch (Dispatchers.IO){
            try {
                val response = repository.getUsersInRepository()
                liveDataOfUsers.postValue(response)
            }catch (e: Exception){
                Log.d("GKB", "getUsersIntoViewModel: ${e.message}")
            }
        }
    }
}