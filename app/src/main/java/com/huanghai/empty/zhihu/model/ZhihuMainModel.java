package com.huanghai.empty.zhihu.model;


import com.huanghai.empty.zhihu.contract.ZhihuContract;

/**
 * Created by hpw on 16/10/31.
 */

public class ZhihuMainModel implements ZhihuContract.ZhihuMainModel {
    @Override
    public String[] getTabs() {
        String[] mTabs = {"日报", "专栏", "微信", "热门"};
        return mTabs;//暂时不从网络取
    }
}