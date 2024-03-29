package com.example.mvvm.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvm.R
import com.example.mvvm.data.db.entities.User
import com.example.mvvm.databinding.ActivityLoginBinding
import com.example.mvvm.util.hide
import com.example.mvvm.util.show
import com.example.mvvm.util.toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(),AuthListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityLoginBinding = DataBindingUtil.
                setContentView(this,R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel
        viewModel.authListener = this
    }

    override fun onStarted() {
        progress_bar.show()
        toast("onStarted")
    }

    override fun onSuccess(user: User) {
        progress_bar.hide()
        toast("${user.name} is logged in!")
    }

    override fun onFailure(message: String) {
        progress_bar.hide()
    }
}
