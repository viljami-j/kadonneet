package com.ihmistenit.kadonneet.ui.user_advert

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ihmistenit.kadonneet.R


/**
 * A fragment representing a list of Items.
 */
class UserAdvertListFragment : Fragment() {

    private var columnCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_user_advert_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }

                val list: MutableList<UserAdvertItem> = mutableListOf()
                val testBMP: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.ic_fg)
                list.add(UserAdvertItem("RND_ID1", "Musta lompakko", testBMP, "tänään 18:10"))
                list.add(UserAdvertItem("RND_ID2", "Vanha Peugeot", testBMP, "eilen 11:10"))
                list.add(UserAdvertItem("RND_ID3", "Punainen hattu", testBMP, "1.1.2020 10:10"))

                adapter = UserAdvertRecyclerViewAdapter(list)
            }
        }
        return view
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            UserAdvertListFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}