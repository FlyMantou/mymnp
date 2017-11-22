package com.huanghai.empty.main.presenter;

import com.huanghai.empty.main.contract.MyContract;
import com.huanghai.empty.main.model.MyListBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huanghai on 2017/4/6.
 */

public class MyPresenter extends MyContract.MyPresenter{
    @Override
    public void onStart() {
        //getMybList(0,0);
    }


    @Override
    public void getMybList(int num,int page) {
        /*MyListBean myListBean = new MyListBean();
        List<MyListBean.DataEntity> dataEntities = new ArrayList<>();
        for (int x=0;x<20;x++){
            MyListBean.DataEntity dataEntity = new MyListBean.DataEntity();
            dataEntity.setName("huanghia");
            dataEntity.setCount(20);
            dataEntity.setIp("123456");
            dataEntities.add(dataEntity);
        }

        myListBean.setData(dataEntities);
        mView.showList(myListBean);*/

       mRxManager.add(mModel.getMyData(num,page)
                .subscribe(
                        myListBean -> {
                            mView.showList(myListBean);
                        }
                        , e -> mView.showError("数据加载失败ヽ(≧Д≦)ノ"+e)
                ));
    }
}
