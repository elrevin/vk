package me.elrevin.vkgroupclient.di.component;

import javax.inject.Singleton;

import dagger.Component;
import me.elrevin.vkgroupclient.activity.BaseActivity;
import me.elrevin.vkgroupclient.activity.MainActivity;
import me.elrevin.vkgroupclient.di.module.ApplicationModule;
import me.elrevin.vkgroupclient.di.module.ManagerModule;
import me.elrevin.vkgroupclient.di.module.RestModule;
import me.elrevin.vkgroupclient.fragments.NewsFeedFragment;

@Singleton
@Component (modules = {ApplicationModule.class, ManagerModule.class, RestModule.class})
public interface ApplicationComponent {
    void inject(BaseActivity activity);
    void inject(MainActivity activity);

    void inject(NewsFeedFragment newsFeedFragment);
}
