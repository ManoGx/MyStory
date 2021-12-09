package com.example.mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        moveToLoginScreen()
    }
    private fun moveToLoginScreen(){
        //هذا الكود خاص بعمل تأخير لتنفيذ الاكواد البرمجية
        Handler(Looper.myLooper()!!).postDelayed({
            //هذه الدالة تستخدم لحذف الواجهة من الذاكرة
            finish()
            val i = Intent(this,LoginActivity::class.java)
            startActivity(i)
        },3000)
    }
}