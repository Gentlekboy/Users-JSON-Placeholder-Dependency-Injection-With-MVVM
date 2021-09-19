package com.gentlekboy.dependencyinjectionclasswork.networkClient

import com.gentlekboy.dependencyinjectionclasswork.model.UserData
import retrofit2.Response
import retrofit2.http.GET

interface GetUsersInterface {

    //Get users from endpoint
    @GET("users")
    suspend fun getUsersFromEndpoint(): Response<UserData>
}