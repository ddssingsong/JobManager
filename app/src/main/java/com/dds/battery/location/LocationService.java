package com.dds.battery.location;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.dds.battery.JobManager;


public class LocationService extends Service {

    public static final String TAG = "dds_LocationService";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "开始定位...");
        JobManager.getInstance().init(this);
        LocationManager.getInstance().startLocation(this);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        //释放
        LocationManager.getInstance().destroyLocation();
        //注销广播接收者
    }

}
