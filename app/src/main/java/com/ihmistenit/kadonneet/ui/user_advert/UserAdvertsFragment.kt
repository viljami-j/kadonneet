package com.ihmistenit.kadonneet.ui.user_advert

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.ihmistenit.kadonneet.R
import com.ihmistenit.kadonneet.ui.maps.MapsFragment

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
    private lateinit var rootView: View
    private lateinit var tabs: TabLayout
    private var selectedTab: Int = 0

    private fun initUserAdvertListFragment() {
        val name = UserAdvertListFragment::class.java.name
        if (childFragmentManager.findFragmentByTag(name) == null) {
            childFragmentManager.beginTransaction()
                .add(R.id.tabContentFragContainer, UserAdvertListFragment(), name)
                .addToBackStack(name)
                .commit()
        }
    }

    private fun initMapsFragment() {
        val name = MapsFragment::class.java.name
        if (childFragmentManager.findFragmentByTag(name) == null) {
            childFragmentManager.beginTransaction()
                .add(R.id.tabContentFragContainer, MapsFragment(), name)
                .addToBackStack(name)
                .commit()
        }
    }

    private fun initTabs() {
        tabs.addTab(tabs.newTab().setText(getString(R.string.tab_text_1)))
        tabs.addTab(tabs.newTab().setText(getString(R.string.tab_text_2)))
        tabs.tabGravity = TabLayout.GRAVITY_FILL
        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                selectedTab = tabs.selectedTabPosition
                syncToSelectedTab()
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }

    private fun syncToSelectedTab() {
        tabs.selectTab(tabs.getTabAt(selectedTab))
        if (selectedTab == 0) {
            val ft: FragmentTransaction = childFragmentManager.beginTransaction()
            val frag: Fragment? = childFragmentManager.findFragmentByTag(UserAdvertListFragment::class.java.name)
            if (frag != null) {
                ft.replace(R.id.tabContentFragContainer, frag).commit()
            } else initUserAdvertListFragment()
        } else if (selectedTab == 1) {
            val ft: FragmentTransaction = childFragmentManager.beginTransaction()
            val frag: Fragment? = childFragmentManager.findFragmentByTag(MapsFragment::class.java.name)
            if (frag != null) {
                ft.replace(R.id.tabContentFragContainer, frag).commit()
            } else initMapsFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_user_adverts, container, false)

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tabs = rootView.findViewById(R.id.tabs)

        initTabs()
        syncToSelectedTab()
    }

    override fun onDestroyView() {
        super.onDestroyView()

        val tabs: TabLayout = rootView.findViewById(R.id.tabs)
        selectedTab = tabs.selectedTabPosition
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