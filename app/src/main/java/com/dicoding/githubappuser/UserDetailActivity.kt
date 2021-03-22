package com.dicoding.githubappuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class UserDetailActivity : AppCompatActivity() {

    companion object {
        const val USER_PHOTO = "user_photo"
        const val USER_USERNAME = "user_username"
        const val USER_FULLNAME = "user_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)

        val imgPhoto: ImageView = findViewById(R.id.img_item_photo)
        val tvUsername: TextView = findViewById(R.id.tv_username)
        val tvFullName: TextView = findViewById(R.id.tv_fullName)

        val image = intent.getIntExtra(USER_PHOTO, 0)
        val uname = intent.getStringExtra(USER_USERNAME)
        val fullName = intent.getStringExtra(USER_FULLNAME)

        imgPhoto.setImageResource(image)
        tvUsername.text = uname
        tvFullName.text = fullName
    }
}