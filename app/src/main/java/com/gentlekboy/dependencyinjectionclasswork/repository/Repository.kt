package com.gentlekboy.dependencyinjectionclasswork.repository

import com.gentlekboy.dependencyinjectionclasswork.model.UserData
import com.gentlekboy.dependencyinjectionclasswork.networkClient.GetUsersInterface
import retrofit2.Response
import javax.inject.Inject

//Connects the connected retrofit to the function making the get request in the interface in order to make a get request
class Repository @Inject constructor(private val getUsersInterface: GetUsersInterface) {
    suspend fun getUsersInRepository(): Response<UserData> {
        return getUsersInterface.getUsersFromEndpoint()
    }
}