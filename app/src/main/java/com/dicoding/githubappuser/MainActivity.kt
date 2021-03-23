package com.dicoding.githubappuser

import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.githubappuser.UserDetailActivity.Companion.EXTRA_USER

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: UserAdapter
    private lateinit var dataUsername: Array<String>
    private lateinit var dataFullName: Array<String>
    private lateinit var dataPhoto: TypedArray
    private lateinit var dataLocation: Array<String>
    private lateinit var dataFollowers: TypedArray
    private lateinit var dataFollowing: TypedArray
    private lateinit var dataRepo: TypedArray
    private lateinit var dataCompany: Array<String>
    private var users = arrayListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prepare()
        addItem()
        setRecyclerView()
    }

    private fun prepare() {
        dataUsername = resources.getStringArray(R.array.username)
        dataFullName = resources.getStringArray(R.array.name)
        dataPhoto = resources.obtainTypedArray(R.array.avatar)
        dataLocation = resources.getStringArray(R.array.location)
        dataFollowers = resources.obtainTypedArray(R.array.followers)
        dataFollowing = resources.obtainTypedArray(R.array.following)
        dataRepo = resources.obtainTypedArray(R.array.repository)
        dataCompany = resources.getStringArray(R.array.company)
    }

    private fun addItem() {
        for (position in dataUsername.indices) {
            val user = User(
                    dataPhoto.getResourceId(position, -1),
                    dataUsername[position],
                    dataFullName[position],
                    dataLocation[position],
                    dataFollowers.getInt(position, -1),
                    dataFollowing.getInt(position, -1),
                    dataRepo.getInt(position, -1),
                    dataCompany[position]
            )
            users.add(user)
        }
    }

    private fun setRecyclerView() {
        val rvUsers: RecyclerView = findViewById(R.id.rv_users)
        adapter = UserAdapter(users) { user ->
            Intent(this, UserDetailActivity::class.java).also {
                it.putExtra(EXTRA_USER, user)
                startActivity(it)
            }
        }
        rvUsers.adapter = adapter
    }
}