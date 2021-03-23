package com.dicoding.githubappuser

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User (
    var photo: Int,
    var username: String,
    var name: String,
    var location: String,
    var followers: Int,
    var following: Int,
    var repo: Int,
    var company: String
        ) : Parcelable