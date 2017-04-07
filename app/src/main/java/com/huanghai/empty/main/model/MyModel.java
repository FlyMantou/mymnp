package com.huanghai.empty.main.model;

import com.hpw.mvpframe.data.net.RxService;

import com.hpw.mvpframe.utils.helper.RxUtil;
import com.huanghai.empty.api.MainApi;
import com.huanghai.empty.main.contract.MyContract;

import rx.Observable;

/**
 * Created by huanghai on 2017/4/6.
 */

public class MyModel implements MyContract.MyModel{
    @Override
    public Observable<MyListBean> getMyData(int num,int page) {
        return  RxService.createApi(MainApi.class).getMyList("这里是服务器校验码，可以不用",num,page).compose(RxUtil.rxSchedulerHelper());
    }
}
