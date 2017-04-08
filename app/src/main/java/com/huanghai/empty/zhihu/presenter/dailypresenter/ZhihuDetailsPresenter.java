package com.huanghai.empty.zhihu.presenter.dailypresenter;


import com.huanghai.empty.zhihu.contract.ZhihuContract;

/**
 * Created by hpw on 16/11/3.
 */

public class ZhihuDetailsPresenter extends ZhihuContract.ZhihuDetailsPresenter {
    @Override
    public void getZhihuDetails(int anInt) {
        mRxManager.add(mModel
                .getZhihuDetails(anInt)
                .subscribe(
                        themeChildListBean -> mView.showContent(themeChildListBean),
                        e -> mView.showError("数据加载失败ヽ(≧Д≦)ノ")
                ));
    }

    @Override
    public void onStart() {

    }
}
