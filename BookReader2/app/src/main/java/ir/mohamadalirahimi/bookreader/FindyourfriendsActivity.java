package ir.mohamadalirahimi.bookreader;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class FindyourfriendsActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{
    Activity context = this;

    Toolbar mToolbar;
    TabLayout tbLayout;
    ViewPager vPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findyourfriends);

        mToolbar = findViewById(R.id.m_toolbar);

        mToolbar.setTitle("Finds & Follows ");

        setSupportActionBar(mToolbar);

        vPager = findViewById(R.id.view_pager);
        tbLayout = findViewById(R.id.tab_layout);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFrag(new FriendsFragment(), "FRIENDS");
        adapter.addFrag(new FollowingFragment(), "FOLLOWING");
        adapter.addFrag(new FollowersFragment(), "FOLLOWERS");

        vPager.setAdapter(adapter);

        tbLayout.setupWithViewPager(vPager);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

        @Override
        public void onBackPressed() {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }





        @SuppressWarnings("StatementWithEmptyBody")
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            // Handle navigation view item clicks here.
            int id = item.getItemId();

            if (id == R.id.nav_Home) {

                // Handle the camera action
                Intent intent = new Intent(context, HomeActivity.class);
                startActivity(intent);

            } else if (id == R.id.nav_Category) {
                Intent intent = new Intent(context, HomeActivity.class);
                startActivity(intent);

//           Intent intent = new Intent(getApplicationContext(), MyBooksFragment.class);
//           String myVariable_1 = "1";
//           intent.putExtra("MYBOOK", myVariable_1);
//           startActivity(intent);

            } else if (id == R.id.nav_Findyourfriends) {



            } else if (id == R.id.nav_BestBookof2018) {

            } else if (id == R.id.nav_share) {

            } else if (id == R.id.nav_send) {

            }

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;



    }
}
