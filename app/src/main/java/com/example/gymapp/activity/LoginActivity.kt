package com.example.gymapp.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gymapp.databinding.ActivityLoginBinding
class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginbtn.setOnClickListener {

            if(validateLogin()){
                getLogin()
            }
        }
        binding.forgetpass.setOnClickListener {

        }
    }

    private fun getLogin() {

        try {
//           val sqlQuery =
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    private fun validateLogin(): Boolean {
        if (binding.loginId.text.toString().trim().isEmpty()) {
            Toast.makeText(this, "Enter User Name", Toast.LENGTH_SHORT).show()
            return false
        } else if (binding.password.text.toString().trim().isEmpty()) {
            Toast.makeText(this, "Enter User Password", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}