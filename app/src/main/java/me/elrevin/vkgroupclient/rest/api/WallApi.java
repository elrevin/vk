package me.elrevin.vkgroupclient.rest.api;

import me.elrevin.vkgroupclient.rest.model.responce.BaseItemResponce;
import me.elrevin.vkgroupclient.rest.model.responce.Full;
import me.elrevin.vkgroupclient.rest.model.responce.WallGetResponce;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WallApi {

    @GET(ApiMethods.WALL_GET)
    Call<WallGetResponce> get(
            @Query("owner_id") String owner_id,
            @Query("access_token") String access_token,
            @Query("extended") int extended,
            @Query("v") String v
            );
}
