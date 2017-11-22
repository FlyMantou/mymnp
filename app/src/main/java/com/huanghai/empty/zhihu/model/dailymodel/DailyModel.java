package com.huanghai.empty.zhihu.model.dailymodel;

import com.myhuanghai.mvpcore.data.net.RxService;
import com.myhuanghai.mvpcore.utils.helper.RxUtil;
import com.huanghai.empty.api.ZhiHuApi;
import com.huanghai.empty.zhihu.contract.ZhihuContract;


import rx.Observable;

/**
 * Created by hpw on 16/11/2.
 */
public class DailyModel implements ZhihuContract.DailyModel {

    @Override
    public Observable<DailyListBean> getDailyData() {
        return RxService.createApi(ZhiHuApi.class).getDailyList().compose(RxUtil.rxSchedulerHelper());
    }

    @Override
    public Observable<ZhihuDetailBean> getZhihuDetails(int anInt) {
        return RxService.createApi(ZhiHuApi.class).getDetailInfo(anInt).compose(RxUtil.rxSchedulerHelper());
    }
}
