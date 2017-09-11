package me.elrevin.vkgroupclient.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;

import me.elrevin.vkgroupclient.R;
import me.elrevin.vkgroupclient.common.manager.CommonFragmentManager;

public abstract class BaseFragment extends MvpAppCompatFragment {
    @LayoutRes
    protected abstract int getMainContentLayout();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getMainContentLayout(), container, false);
    }

    @StringRes
    public abstract int onCreateToolbarTitle();

    public String createToolbarTitle (Context context) {
        return context.getString(onCreateToolbarTitle());
    }
}
