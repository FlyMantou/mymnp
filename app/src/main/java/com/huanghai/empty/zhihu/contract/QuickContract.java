package com.huanghai.empty.zhihu.contract;

import com.myhuanghai.mvpcore.base.CoreBaseModel;
import com.myhuanghai.mvpcore.base.CoreBasePresenter;
import com.myhuanghai.mvpcore.base.CoreBaseView;
import com.huanghai.empty.zhihu.model.quick.Status;

import java.util.List;

/**
 * Created by hpw on 16/11/1.
 */

public interface QuickContract {
    interface Model extends CoreBaseModel {
        List<Status> getData();
    }

    interface View extends CoreBaseView {

    }

    abstract class Presenter extends CoreBasePresenter<Model, View> {

    }
}
