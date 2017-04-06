package com.huanghai.empty.main.activity;

import android.os.Bundle;

import com.hpw.mvpframe.base.CoreBaseActivity;
import com.huanghai.empty.R;
import com.huanghai.empty.main.model.MyModel;
import com.huanghai.empty.main.presenter.MyPresenter;

public class MainActivity extends CoreBaseActivity<MyPresenter,MyModel>{


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {//初始化页面数据

    }
}
