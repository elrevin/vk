package me.elrevin.vkgroupclient.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.arellomobile.mvp.MvpAppCompatActivity;

import javax.inject.Inject;

import me.elrevin.vkgroupclient.EvkApplication;
import me.elrevin.vkgroupclient.R;
import me.elrevin.vkgroupclient.common.manager.CommonFragmentManager;
import me.elrevin.vkgroupclient.fragments.BaseFragment;

public abstract class BaseActivity extends MvpAppCompatActivity {

    @Inject
    CommonFragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EvkApplication.getApplicationComponent().inject(this);

        setContentView(R.layout.activity_base);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FrameLayout parent = (FrameLayout) findViewById(R.id.main_wrapper);
        getLayoutInflater().inflate(getMainContentLayout(), parent);
    }

    public void fragmentOnScreen(BaseFragment fragment) {
        setToolbarTitle(fragment.createToolbarTitle(this));
    }

    @LayoutRes
    protected abstract int getMainContentLayout();

    public void setContent(BaseFragment fragment) {
        fragmentManager.setFragment(this, fragment, R.id.main_wrapper);
    }

    public void addContent(BaseFragment fragment) {
        fragmentManager.addFragment(this, fragment, R.id.main_wrapper);
    }

    public boolean removeCurrentFragment() {
        return fragmentManager.removeCurrentFragment(this);
    }

    public boolean removeFragment(BaseFragment fragment) {
        return fragmentManager.removeFragment(this, fragment);
    }

    public void setToolbarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public void onBackPressed() {
        removeCurrentFragment();
    }

}
