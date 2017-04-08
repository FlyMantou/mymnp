package com.huanghai.empty.Style1Main.presenter;

import com.huanghai.empty.Style1Main.contract.MainContract;

/**
 * Created by huanghai on 2017/4/8.
 */

public class MainPresenter extends MainContract.MainPresenter{
    @Override
    public void getTabList() {
        mView.showTabList(mModel.getTabs(),mModel.getTabsIcon());
    }

    @Override
    public void onStart() {
        getTabList();
    }
}
