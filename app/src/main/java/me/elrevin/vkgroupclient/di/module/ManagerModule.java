package me.elrevin.vkgroupclient.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.elrevin.vkgroupclient.common.manager.CommonFragmentManager;

@Module
public class ManagerModule {

    @Singleton
    @Provides
    CommonFragmentManager provideFragmentManager() {
        return new CommonFragmentManager();
    }
}
