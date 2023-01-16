package com.ihmistenit.kadonneet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [UserAdvertsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UserAdvertsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private fun initUserAdvertListFragment() {
        val name = UserAdvertListFragment::class.java.name
        if (activity?.supportFragmentManager?.findFragmentByTag(name) == null) {
            activity?.supportFragmentManager?.beginTransaction()
                ?.add(R.id.tabContentFragContainer, UserAdvertListFragment(), name)
                ?.addToBackStack(name)
                ?.commit()
        }
    }

    private fun initMapsFragment() {
        val name = MapsFragment::class.java.name
        if (activity?.supportFragmentManager?.findFragmentByTag(name) == null) {
            activity?.supportFragmentManager?.beginTransaction()
                ?.add(R.id.tabContentFragContainer, MapsFragment(), name)
                ?.addToBackStack(name)
                ?.commit()
        }
    }

    private fun initTabs(tabLayout: TabLayout) {
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_text_1)))
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_text_2)))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                if (tabLayout.selectedTabPosition == 0) {
                    val ft: FragmentTransaction? = activity?.supportFragmentManager?.beginTransaction()
                    val frag: Fragment? = activity?.supportFragmentManager?.findFragmentByTag(UserAdvertListFragment::class.java.name)
                    if (frag != null) {
                        ft?.replace(R.id.tabContentFragContainer, frag)?.commit()
                    }
                } else if (tabLayout.selectedTabPosition == 1) {
                    val ft: FragmentTransaction? = activity?.supportFragmentManager?.beginTransaction()
                    val frag: Fragment? = activity?.supportFragmentManager?.findFragmentByTag(MapsFragment::class.java.name)
                    if (frag != null) {
                        ft?.replace(R.id.tabContentFragContainer, frag)?.commit()
                    } else initMapsFragment()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_user_adverts, container, false)

        initUserAdvertListFragment()
        initTabs(rootView.findViewById(R.id.tabs))

        val fab: FloatingActionButton = rootView.findViewById(R.id.fab)
        fab.bringToFront()
        fab.setOnClickListener { view ->
            Snackbar.make(rootView, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        return rootView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment UserAdvertsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            UserAdvertsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}