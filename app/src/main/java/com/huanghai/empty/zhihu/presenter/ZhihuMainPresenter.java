package com.huanghai.empty.zhihu.presenter;


import com.huanghai.empty.zhihu.contract.ZhihuContract;

/**
 * Created by hpw on 16/10/31.
 */

public class ZhihuMainPresenter extends ZhihuContract.ZhihuMainPresenter {

    @Override
    public void getTabList() {
        mView.showTabList(mModel.getTabs());
    }

    @Override
    public void onStart() {
        getTabList();
    }
}