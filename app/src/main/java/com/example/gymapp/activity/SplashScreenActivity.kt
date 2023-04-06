package com.example.gymapp.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.gymapp.databinding.ActivitySplashScreenBinding
import com.example.gymapp.global.DB
import com.example.gymapp.manager.SessionManager

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {

    var db: DB? = null
    var session: SessionManager? = null

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = DB(this)
        session = SessionManager(this)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            insertAdminData()
            startActivity(intent)
        }, 4000)
    }

    private fun insertAdminData() {
        try {
            val sqlCheck = "SELECTED * FROM ADMIN"
            db?.fireQuery(sqlCheck)?.use {
                if (it.count > 0) {
                    Log.d("SplashActivity", "data available")

                } else {
                    val sqlQuery =
                        "INSERT OR REPLACE INTO ADMIN(ID,USER_NAME,PASSWORD,MOBILE)VALUES('1','Admin','123456',''8888888888')"
                    db?.executeQuery(sqlQuery)
                }
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//
//    }
}
