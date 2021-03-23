package com.dicoding.githubappuser

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class UserDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)

        val imgPhoto: ImageView = findViewById(R.id.img_item_photo)
        val tvUsername: TextView = findViewById(R.id.tv_username)
        val tvFullName: TextView = findViewById(R.id.tv_fullName)
        val tvLocation: TextView = findViewById(R.id.tv_location)
        val tvFollowers: TextView = findViewById(R.id.tv_followers)
        val tvFollowing: TextView = findViewById(R.id.tv_following)
        val tvRepo: TextView = findViewById(R.id.tv_repo)
        val tvCompany: TextView = findViewById(R.id.tv_company)

        val user = intent.getParcelableExtra<User>(EXTRA_USER)

        imgPhoto.setImageResource(user.photo)
        tvUsername.text = user.username
        tvFullName.text = user.name
        tvLocation.text = user.location
        tvFollowers.text = user.followers.toString()
        tvFollowing.text = user.following.toString()
        tvRepo.text = user.repo.toString()
        tvCompany.text = user.company
    }
}