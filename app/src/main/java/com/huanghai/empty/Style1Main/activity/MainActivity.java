package com.huanghai.empty.Style1Main.activity;

import android.os.Bundle;

import com.hpw.mvpframe.base.CoreBaseActivity;
import com.huanghai.empty.R;
import com.huanghai.empty.Style1Main.contract.MainContract;
import com.huanghai.empty.Style1Main.fragment.MainFragment;
import com.huanghai.empty.Style1Main.model.MainModel;
import com.huanghai.empty.Style1Main.presenter.MainPresenter;

/**
 * Created by huanghai on 2017/4/8.
 */

public class MainActivity extends CoreBaseActivity<MainPresenter,MainModel> implements MainContract,MainFragment.OnBackToFirstListener{


    @Override
    public int getLayoutId() {
        return R.layout.activity_style1main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            loadRootFragment(R.id.fl_container, MainFragment.newInstance(0));
        }
    }


    @Override
    public void onBackToFirstFragment() {
        loadRootFragment(R.id.fl_container, MainFragment.newInstance(1));
    }
}
