package com.huanghai.empty.main.model;


import com.myhuanghai.mvpcore.data.net.RxService;
import com.myhuanghai.mvpcore.utils.LogUtil;
import com.myhuanghai.mvpcore.utils.helper.RxUtil;
import com.huanghai.empty.api.MainApi;
import com.huanghai.empty.main.contract.MyContract;

import rx.Observable;

/**
 * Created by huanghai on 2017/4/6.
 */

public class MyModel implements MyContract.MyModel{
    @Override
    public Observable<MyListBean> getMyData(int num,int page) {
        LogUtil.i("huanghai","请求网络--->"+page);
        return  RxService.createApi(MainApi.class)
                .getMyList("sssssss",num,page)
                .compose(RxUtil.rxSchedulerHelper());
    }
}
