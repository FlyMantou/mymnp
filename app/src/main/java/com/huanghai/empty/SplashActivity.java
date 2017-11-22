package com.huanghai.empty;

import android.Manifest;
import android.os.Bundle;

import com.myhuanghai.mvpcore.base.CoreBaseActivity;
import com.myhuanghai.mvpcore.utils.helper.RxUtil;
import com.huanghai.empty.main.activity.MainActivity;
import com.huanghai.empty.zhihu.activity.ZhihuMainActivity;
import com.tbruyelle.rxpermissions.RxPermissions;

import java.util.concurrent.TimeUnit;

import rx.Observable;

/**
 * Created by hpw on 16/10/28.
 */

public class SplashActivity extends CoreBaseActivity {
    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initData() {

    }

    @Override
    public boolean isOpen() {
        return true;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        Observable.timer(2000, TimeUnit.MILLISECONDS)
                .compose(RxPermissions.getInstance(this).ensureEach(Manifest.permission.READ_PHONE_STATE, Manifest.permission.CAMERA,
                        Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.ACCESS_COARSE_LOCATION))
                .compose(RxUtil.rxSchedulerHelper())
                .subscribe(permission -> {
                    if (permission.granted) {
                        startActivity(com.huanghai.empty.main.activity.MainActivity.class);
                        finish();
                    }
                });
    }

}
