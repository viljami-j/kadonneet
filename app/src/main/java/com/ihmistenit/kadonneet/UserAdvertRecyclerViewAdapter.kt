package com.ihmistenit.kadonneet

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView

import com.ihmistenit.kadonneet.placeholder.PlaceholderContent.UserAdvertItem
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
        holder.contentView.text = item.content
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentUserAdvertItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val contentView: TextView = binding.content

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

}