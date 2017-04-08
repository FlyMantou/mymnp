package com.huanghai.empty.main.presenter;

import com.huanghai.empty.main.contract.MyContract;

/**
 * Created by huanghai on 2017/4/6.
 */

public class MyPresenter extends MyContract.MyPresenter{
    @Override
    public void onStart() {

    }


    @Override
    public void getMybList(int num,int page) {

        mRxManager.add(mModel.getMyData(num,page)
                .subscribe(
                        myListBean -> mView.showList(myListBean)
                        , e -> mView.showError("数据加载失败ヽ(≧Д≦)ノ"+e)
                ));
    }
}
