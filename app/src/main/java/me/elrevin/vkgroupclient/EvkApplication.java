package me.elrevin.vkgroupclient;

import android.app.Application;

import com.vk.sdk.VKSdk;

import me.elrevin.vkgroupclient.di.component.ApplicationComponent;
import me.elrevin.vkgroupclient.di.component.DaggerApplicationComponent;
import me.elrevin.vkgroupclient.di.module.ApplicationModule;

public class EvkApplication extends Application {

    private static ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        VKSdk.initialize(this);
        initComponent();
    }

    private void initComponent() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
    }

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
