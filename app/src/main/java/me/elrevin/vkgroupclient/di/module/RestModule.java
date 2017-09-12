package me.elrevin.vkgroupclient.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.elrevin.vkgroupclient.rest.RestClient;
import me.elrevin.vkgroupclient.rest.api.WallApi;

@Module
public class RestModule {
    private RestClient restClient;

    public RestModule() {
        restClient = new RestClient();
    }

    @Singleton
    @Provides
    public RestClient provideRestClient() {
        return restClient;
    }

    @Singleton
    @Provides
    public WallApi provideWallApi() {
        return restClient.createService(WallApi.class);
    }
}
