package me.elrevin.vkgroupclient.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import me.elrevin.vkgroupclient.CurrentUser;
import me.elrevin.vkgroupclient.mvp.view.MainView;

/**
 * Created by elrevin on 02.09.2017.
 */

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {
    public void checkAuth() {
        if (!CurrentUser.isAutorized()) {
            getViewState().startSignIn();
        } else {
            getViewState().signedId();
        }
    }
}
