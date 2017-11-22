package com.huanghai.empty.zhihu.model.wechatmodel;

import com.myhuanghai.mvpcore.data.net.RxService;
import com.myhuanghai.mvpcore.utils.helper.RxUtil;
import com.huanghai.empty.Constants;
import com.huanghai.empty.api.WechatApi;
import com.huanghai.empty.zhihu.contract.ZhihuContract;

import java.util.List;

import rx.Observable;

/**
 * Created by hpw on 16/11/6.
 */
public class WechatModel implements ZhihuContract.WechatModel {
    @Override
    public Observable<List<WXItemBean>> getWechatData(int num, int page) {
        return RxService.createApi(WechatApi.class, WechatApi.HOST)
                .getWXHot(Constants.WEIXIN_KEY, num, page)
                .compose(RxUtil.rxSchedulerHelper())
                .compose(RxUtil.handleResult());
    }
}
