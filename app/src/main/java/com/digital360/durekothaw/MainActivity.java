package com.digital360.durekothaw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ActionBarDrawerToggle toggle;
    DrawerLayout drawer;
    NavigationView navigationView;
    String[] suchona;

    ListView lists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView = findViewById(R.id.nav_view);
        drawer = findViewById(R.id.drawer_layout);
        lists=findViewById(R.id.listId);


        suchona=getResources().getStringArray(R.array.chapter);

        ArrayAdapter<String> mA=new ArrayAdapter<>(MainActivity.this,R.layout.list_item,R.id.testId,suchona);
        lists.setAdapter(mA);

        toggle = new ActionBarDrawerToggle(MainActivity.this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);

        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(MainActivity.this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        lists.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent =new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("value",position+1);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                break;
            case R.id.k_kotha_koi:
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.digital360.joybangla"));
                startActivity(intent);

                break;
            case R.id.bristy_bilash:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.aibt.rupa"));
                startActivity(intent);
                break;
            case R.id.bristy_o_meghmala:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.aibt.megherchaya"));
                startActivity(intent);

                break;
            case R.id.appstore:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/dev?id=8957568887029131075"));
                startActivity(intent);

                break;
        }
        //     drawer.closeDrawer(GravityCompat.START);
        //return false;
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }
}

