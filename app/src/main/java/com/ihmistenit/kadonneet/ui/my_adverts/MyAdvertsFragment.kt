package com.ihmistenit.kadonneet.ui.my_adverts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.ihmistenit.kadonneet.R
import com.ihmistenit.kadonneet.databinding.FragmentMyAdvertsBinding
import com.ihmistenit.kadonneet.ui.user_advert.UserAdvertListFragment

class MyAdvertsFragment : Fragment() {

    private var _binding: FragmentMyAdvertsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val myAdvertsViewModel =
            ViewModelProvider(this)[MyAdvertsViewModel::class.java]

        _binding = FragmentMyAdvertsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (childFragmentManager.findFragmentByTag("MyAdverts") == null) {
            childFragmentManager.beginTransaction()
                .add(R.id.fragContainer, UserAdvertListFragment(), "MyAdverts")
                .addToBackStack("MyAdverts")
                .commit()
        }

        val fab: FloatingActionButton? = _binding?.fab ?: null
        if (fab != null) {
            fab.bringToFront()
            fab.setOnClickListener {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}