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
    public Observable<Object> getMyData() {
        return RxService.createApi(MainApi.class).getMyList().compose(RxUtil.rxSchedulerHelper());
    }
}
