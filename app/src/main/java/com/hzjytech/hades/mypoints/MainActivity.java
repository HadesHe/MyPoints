package com.hzjytech.hades.mypoints;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;


import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.DiskLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


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
                Log.d("TAG","I'm a log which you don't see easily,hehe");
                Log.d("json content","{\"key\":3,\n\"value\": something}");
                Log.d("error","There is a crash somewhere or any warning");

                Logger.addLogAdapter(new AndroidLogAdapter());
                Logger.d("message");
                Logger.clearLogAdapters();

                FormatStrategy formatStrategy= PrettyFormatStrategy.newBuilder()
                        .showThreadInfo(false)
                        .methodCount(0)
                        .methodOffset(3)
                        .tag("My custom tag")
                        .build();
                Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));

                Logger.addLogAdapter(new AndroidLogAdapter(){
                    @Override
                    public boolean isLoggable(int priority, String tag) {
                        return BuildConfig.DEBUG;
                    }
                });

                Logger.addLogAdapter(new DiskLogAdapter());

                Logger.w("no thread info and only 1 method");

                Logger.clearLogAdapters();

                formatStrategy=PrettyFormatStrategy.newBuilder()
                        .showThreadInfo(false)
                        .methodCount(0)
                        .build();
                Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));
                Logger.i("no thread info and method info");
                Logger.t("tag").e("Custom tag for only one use");
                Logger.json("{ \"key\": 3, \"value\": something}");

                Logger.d(Arrays.asList("foo","bar"));

                Map<String,String> map=new HashMap<>();
                map.put("key","value1");
                map.put("key1","value2");

                Logger.d(map);

                Logger.clearLogAdapters();

                formatStrategy= PrettyFormatStrategy.newBuilder()
                        .showThreadInfo(false)
                        .methodCount(0)
                        .tag("MyTag")
                        .build();

                Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));

                Logger.w("my log message with my tag");

                return true;
        }
        return false;
    }

    private void setToolBarTitle(String title) {
        tbMain.setTitle(title);
    }
}
