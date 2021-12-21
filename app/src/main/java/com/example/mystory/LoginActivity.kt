package com.example.mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    private var editTextUsername: EditText ? = null
    private var editTextPassword: EditText ? = null
    private var buttonLogin: Button ? = null
    private var checkBoxView: CheckBox ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        connectViews()
        login()
//        checkFields()
    }
    private fun connectViews(){
        editTextUsername = findViewById(R.id.etUsername)
        editTextPassword = findViewById(R.id.etPassword)
        buttonLogin = findViewById(R.id.btnLogin)
        checkBoxView = findViewById(R.id.checkbox)
    }
    private fun login(){
        val arr:ArrayList<User> = ArrayList()

        arr.add(User("test@test.com","1234"))
        arr.add(User("t@gmail.com","12345"))
        arr.add(User("b@test.com","123456"))
        arr.add(User("alialqatari@outlook.com","mano1998"))

        buttonLogin?.setOnClickListener {
            val username = editTextUsername?.text.toString() // مدخل بواسطة المستخدم (الايميل)
            val password = editTextPassword?.text.toString() // مدخل بواسطة المستخدم (كلمة المرور)

            val user = User(username , password)

            for(userArray in arr){
                //if(userArray.email == user.email
                    //الايكوال عشان يخلي الايميل نفس الحروف ماتفرق كبيرة او صغيرة
                if(userArray.email.equals(user.email,true) && userArray.password == user.password){
//                    Toast.makeText(this,"Welcome ${user.email}",Toast.LENGTH_LONG).show()
                        finish()
                        val i = Intent(this,MainActivity::class.java)
                    //       (username)  هذا التاج عشان استدعيه بعدين
                        i.putExtra("email",userArray.email) //لنقل الايميل للواجهة الجديدة
                    startActivity(i) //خاصة للأنتقال بين الاكتفتي || لكن لو تبي تنتقل بين الفراقمنت تستخدم ()commit
                    break
                }else{
                    Toast.makeText(this,"Check your data",Toast.LENGTH_SHORT).show()
            }
        }
            if(editTextUsername?.text?.isEmpty() == true){
                editTextUsername?.setError("Enter you email") //nice
            }else if (editTextPassword?.text?.isEmpty() == true){
                editTextPassword?.error = "Enter you email" //نفس حق الايميل لكن بطريقة اخرى
            }
        }

    }
    private fun checkFields(){
//        buttonLogin?.setOnClickListener {
//            if(editTextUsername?.text?.isEmpty() == true){
//                editTextUsername?.setError("Enter you email") //nice
//            }else if (editTextPassword?.text?.isEmpty() == true){
//                editTextPassword?.error = "Enter you email" //نفس حق الايميل لكن بطريقة اخرى
//            }
//        }
    }
}