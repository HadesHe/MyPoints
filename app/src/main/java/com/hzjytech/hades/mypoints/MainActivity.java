package com.hzjytech.hades.mypoints;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private ActionBar tbMain;
    private BottomNavigationView bnvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbMain=getSupportActionBar();

        bnvMain=(BottomNavigationView)findViewById(R.id.bnvMain);
        bnvMain.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemNavMovie:
                setToolBarTitle("Movie");
                return true;
            case R.id.itemNavShop:
                setToolBarTitle("Shop");
                return true;
            case R.id.itemNavWatch:
                setToolBarTitle("Watch");
                return true;
        }
        return false;
    }

    private void setToolBarTitle(String title) {
        tbMain.setTitle(title);
    }
}
