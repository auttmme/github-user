package com.dicoding.githubappuser

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: UserAdapter
    private lateinit var dataUsername: Array<String>
    private lateinit var dataFullName: Array<String>
    private lateinit var dataPhoto: TypedArray
    private var users = arrayListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.lv_list)
        adapter = UserAdapter(this)
        listView.adapter = adapter
        
        prepare()
        addItem()
        
        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val intent = Intent(this@MainActivity, UserDetailActivity::class.java)
            intent.putExtra(UserDetailActivity.USER_PHOTO, users[position].photo)
            intent.putExtra(UserDetailActivity.USER_USERNAME, users[position].username)
            intent.putExtra(UserDetailActivity.USER_FULLNAME, users[position].name)
            startActivity(intent)
        }
    }
    
    private fun prepare() {
        dataUsername = resources.getStringArray(R.array.username)
        dataFullName = resources.getStringArray(R.array.name)
        dataPhoto = resources.obtainTypedArray(R.array.avatar)
    }
    
    private fun addItem() {
        for (position in dataUsername.indices) {
            val user = User(
                dataPhoto.getResourceId(position, -1),
                dataUsername[position],
                dataFullName[position]
            )
            users.add(user)
        }
        adapter.users = users
    }
}