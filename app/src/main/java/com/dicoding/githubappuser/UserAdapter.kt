package com.dicoding.githubappuser

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.githubappuser.R
import com.dicoding.githubappuser.User

class UserAdapter(private val users: List<User>, private val clickListener: ((User) -> Unit)?) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_user, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) = holder.bindItem(users[position], clickListener)

    override fun getItemCount(): Int = users.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgPhoto: ImageView = view.findViewById(R.id.img_photo)
        val tvUsername: TextView = view.findViewById(R.id.txt_username)
        val tvFullName: TextView = view.findViewById(R.id.txt_fullName)

        fun bindItem(user: User, clickListener: ((User) -> Unit)?) {
            Glide.with(imgPhoto.context)
                    .load(user.photo)
                    .into(imgPhoto)

            tvUsername.text = user.username
            tvFullName.text = user.name
            itemView.setOnClickListener { clickListener?.let { it(user) } }
        }
    }
}