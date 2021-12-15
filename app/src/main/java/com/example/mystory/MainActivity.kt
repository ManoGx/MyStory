package com.example.mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private var textViewEmail:TextView?=null
    private var drawerLayout:DrawerLayout? = null
    private var toolbarView:Toolbar?=null
    private var navigationView:NavigationView ? =null
    private var recyclerView:RecyclerView ? = null
    private var buttonAddStory:FloatingActionButton ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val email = intent.getStringExtra("email") //عشان نجيب الايميل الي حددناه في الانتنت في اكتفتي لوجن

        connectViews()

        textViewEmail?.text = email //لازم استدعيها بعد دالة الكونكت فيوز عشان ماتكون قيمة الايميل نل
        setSupportActionBar(toolbarView)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //هذه الدالة الي بتطلع لنا علامة الرجوع الي بحوله للهمبرقر

        setupDrawer()
        updateEmailInHeader(email!!)
        drawerClicks()
        openAddStoryActivity()

        displayStories()
    }
    private fun updateEmailInHeader(email:String){//هذه الدالة خاصة لعرض الهيدر واستدعاء الايميل المدخل
        val headerView = navigationView?.getHeaderView(0)
        val textViewEmail = headerView?.findViewById<TextView>(R.id.tvEmail) //عشان نستدعي الايميل عشان نحدثه بالسطر الي تحت دا
        textViewEmail?.text = email
    }
    private fun setupDrawer(){
        val toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout?.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home ->{
                drawerLayout?.openDrawer(GravityCompat.START)
                true
            }
            else -> true
        }
    }
    private fun connectViews(){
        textViewEmail = findViewById(R.id.tvEmail)
        drawerLayout = findViewById(R.id.drawer)
        toolbarView = findViewById(R.id.toolbar)
        navigationView = findViewById(R.id.navView)
        recyclerView = findViewById(R.id.storiesRecyclerView)
        buttonAddStory = findViewById(R.id.btnAddStory)
    }

    private fun drawerClicks(){
        navigationView?.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home ->{
                    drawerLayout?.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.logout ->{
                    finish() //لو ماحطيتها... لما تضغط زر رجوع بيرجعك للشاشة الي قبل
                    val i = Intent(this,LoginActivity::class.java)
                    startActivity(i)
                    true
                }
                else -> true
            }
        }
    }
    private fun openAddStoryActivity(){
        buttonAddStory?.setOnClickListener{
            val i= Intent(this,AddStoryActivity::class.java)
            startActivity(i)
        }
    }

    private fun displayStories(){
        val storiesArray = ArrayList<Story>()
        storiesArray.add(Story(getString(R.string.story1_title),
            getString(R.string.story1_subtitle),getString(R.string.story1_description)))

        storiesArray.add(Story("And this is my Second Story"
            ,"This is subtitle","Welcome to my Story I will show you how I learnt"))
        storiesArray.add(Story("In addition this is my Third Story"
            ,"This is subtitle","Welcome to my Story I will show you how I learnt"))

        val customAdapter = CustomAdapter(storiesArray,this)
        recyclerView?.adapter = customAdapter
    }
}