package com.example.mvvm.ui.auth

import androidx.lifecycle.ViewModel
import com.example.mvvm.data.repositories.UserRepository
import com.example.mvvm.util.ApiException
import com.example.mvvm.util.Coroutines

class AuthViewModel : ViewModel() {

    var email: String? = null
    var password: String? = null

    var authListener: AuthListener? = null

    fun onLoginButtonClick(){
        authListener?.onStarted()
        if (email.isNullOrEmpty() || password.isNullOrEmpty()){
            authListener?.onFailure("Invalid email or password!")
            return
        }
        Coroutines.main {
            try {
                val authResponse = UserRepository().userLogin(email!!,password!!)
                authResponse.user?.let {
                    authListener?.onSuccess(it)
                }
                authListener?.onFailure(authResponse.message!!)
            }catch (e: ApiException){
                authListener?.onFailure(e.message!!)
            }
        }
    }
}