package com.example.menubar

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentTransaction
import com.example.menubar.bottomnavigation.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

open class NavigationActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {

    private lateinit var toolbar: Toolbar
    private lateinit var navigationView: NavigationView

    private lateinit var drawerLayout: DrawerLayout
    lateinit var homeFragment: HomeFragment
    lateinit var searchFragment: SearchFragment
    lateinit var shopbycategoriesFragment: ShopbycategoriesFragment
    lateinit var offersFragment: OffersFragment
    lateinit var cartFragment: CartFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.navigation)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        homeFragment = HomeFragment()
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.nav_host_fragment, homeFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()

        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            //we will select each menu item and add an event when it's selected
            when (item.itemId) {
                R.id.navigation_home -> {
                    homeFragment = HomeFragment()
                    supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.nav_host_fragment, homeFragment)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .commit()
                }
                R.id.navigation_search -> {
                    searchFragment = SearchFragment()
                    supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.nav_host_fragment, searchFragment)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .commit()

                }
                R.id.navigation_Shop -> {
                    shopbycategoriesFragment = ShopbycategoriesFragment()
                    supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.nav_host_fragment, shopbycategoriesFragment)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .commit()

                }
                R.id.navigation_offers -> {
                    offersFragment = OffersFragment()
                    supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.nav_host_fragment, offersFragment)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .commit()

                }
                R.id.navigation_cart -> {
                    cartFragment = CartFragment()
                    supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.nav_host_fragment, cartFragment)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .commit()

                }
            }
            true
        }
        val toggle = ActionBarDrawerToggle(
                this, drawerLayout, toolbar, 0, 0
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navigationView.setNavigationItemSelectedListener(this)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.navigation, menu)
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId)
        {
            R.id.ChangeStore ->{
                val intent = Intent(this, ChangeStore::class.java)
                startActivity(intent) }

            R.id.MyAccount ->{
                val intent = Intent(this, MyAccount::class.java)
                startActivity(intent) }

            R.id.MyOrders ->{
                val intent = Intent(this, MyOrders::class.java)
                startActivity(intent) }

            R.id.OffersZone ->{
                val intent = Intent(this, OffersZone::class.java)
                startActivity(intent) }

            R.id.ReturnPolicy ->{
                val intent = Intent(this, ReturnPolicy::class.java)
                startActivity(intent) }

            R.id.Logout ->{
                val intent = Intent(this, Logout::class.java)
                startActivity(intent) }

        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}