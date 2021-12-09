package com.example.mystory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var textViewEmail:TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val email = intent.getStringExtra("email") //عشان نجيب الايميل الي حددناه في الانتنت في اكتفتي لوجن

        connectViews()

        textViewEmail?.text = email //لازم استدعيها بعد دالة الكونكت فيوز عشان ماتكون قيمة الايميل نل
    }
    private fun connectViews(){
        textViewEmail = findViewById(R.id.tvEmail)
    }
}