package com.dds.battery;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dds.battery.interfaces.Consumer;
import com.dds.battery.location.LocationService;


public class MainActivity extends AppCompatActivity {
    private Intent location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //注意动态权限
        // 添加白名单
        Battery.addWhite(MainActivity.this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Permissions.request(this, new String[]{
                            Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.READ_EXTERNAL_STORAGE},
                    new Consumer<Integer>() {
                        @Override
                        public void accept(Integer integer) {
                            if (integer == PackageManager.PERMISSION_GRANTED) {
                                // 开启定位
                                location = new Intent(MainActivity.this, LocationService.class);
                                startService(location);


                            }

                        }
                    });
        }

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
