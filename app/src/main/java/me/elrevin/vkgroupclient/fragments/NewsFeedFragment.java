package me.elrevin.vkgroupclient.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import javax.inject.Inject;

import me.elrevin.vkgroupclient.CurrentUser;
import me.elrevin.vkgroupclient.EvkApplication;
import me.elrevin.vkgroupclient.R;
import me.elrevin.vkgroupclient.rest.api.WallApi;
import me.elrevin.vkgroupclient.rest.model.responce.BaseItemResponce;
import me.elrevin.vkgroupclient.rest.model.responce.Full;
import me.elrevin.vkgroupclient.rest.model.responce.WallGetResponce;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFeedFragment extends BaseFragment {

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        wallApi.get("-86529522", CurrentUser.getAccessToken(), 1, "5.68").enqueue(new Callback<WallGetResponce>() {
            @Override
            public void onResponse(Call<WallGetResponce> call, Response<WallGetResponce> response) {
                Toast.makeText(getActivity(), "Likes: " + response.body().response.getItems().get(0).getLikes().getCount(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<WallGetResponce> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Inject
    WallApi wallApi;

    public NewsFeedFragment() {
        // Required empty public constructor
    }


    @Override
    protected int getMainContentLayout() {
        return R.layout.fragment_feed;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EvkApplication.getApplicationComponent().inject(this);
    }

    @Override
    public int onCreateToolbarTitle() {
        return R.string.news_screen_title;
    }

}
