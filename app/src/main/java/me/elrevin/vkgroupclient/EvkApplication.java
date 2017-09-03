package me.elrevin.vkgroupclient;

import android.app.Application;

import com.vk.sdk.VKSdk;

/**
 * Created by elrevin on 02.09.2017.
 */

public class EvkApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        VKSdk.initialize(this);
    }
}
