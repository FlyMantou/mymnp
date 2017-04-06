package com.huanghai.empty.main.contract;

import com.hpw.mvpframe.base.CoreBaseModel;
import com.hpw.mvpframe.base.CoreBasePresenter;
import com.hpw.mvpframe.base.CoreBaseView;
import com.huanghai.empty.main.model.MyListBean;


import rx.Observable;

/**
 * Created by huanghai on 2017/4/6.
 */

public interface MyContract {
    //主页接口
    abstract class MyPresenter extends CoreBasePresenter<MyModel,MyView>{

    }
    interface MyModel extends CoreBaseModel{
        Observable<Object> getMyData();//获取观察对象
    }

    interface MyView extends CoreBaseView{
        void showList(MyListBean info);//显示列表
        //其他操作
    }
}
