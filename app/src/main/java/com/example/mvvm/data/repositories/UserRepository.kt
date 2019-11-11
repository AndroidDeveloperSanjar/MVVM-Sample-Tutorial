package com.example.mvvm.data.repositories

import com.example.mvvm.data.network.MyApi
import com.example.mvvm.data.network.SafeApiRequest
import com.example.mvvm.data.network.responses.AuthResponse

class UserRepository : SafeApiRequest() {

    suspend fun userLogin(email: String,password: String) : AuthResponse{
        return apiRequest {
            MyApi().userLogin(email,password)
        }
    }

}