package com.ihmistenit.kadonneet.ui.user_advert

import android.graphics.Bitmap
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.ihmistenit.kadonneet.databinding.FragmentUserAdvertItemBinding

/**
 * [RecyclerView.Adapter] that can display a [UserAdvertItem].
 */
class UserAdvertRecyclerViewAdapter(
    private val values: List<UserAdvertItem>
) : RecyclerView.Adapter<UserAdvertRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FragmentUserAdvertItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.advertTitleView.text = item.title
        holder.advertPostDateView.text = item.postDate
        holder.advertImage.setImageBitmap(item.image)
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentUserAdvertItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val advertTitleView: TextView = binding.advertTitle
        val advertPostDateView: TextView = binding.advertPostdate
        val advertImage: ImageView = binding.advertImage

        override fun toString(): String {
            return super.toString() + " '" + advertTitleView.text + "'" + advertPostDateView.text
        }
    }

}

data class UserAdvertItem(val id: String, val title: String, val image: Bitmap?, val postDate: String) {
    override fun toString(): String = title
}