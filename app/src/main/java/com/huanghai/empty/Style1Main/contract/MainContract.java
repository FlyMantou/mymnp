package com.huanghai.empty.Style1Main.contract;

import com.hpw.mvpframe.base.CoreBaseModel;
import com.hpw.mvpframe.base.CoreBasePresenter;
import com.hpw.mvpframe.base.CoreBaseView;

/**
 * Created by huanghai on 2017/4/8.
 */

public interface MainContract {
     abstract class MainPresenter extends CoreBasePresenter<MainModel,MainView>{

    }
    interface MainModel extends CoreBaseModel{

    }
    interface MainView extends CoreBaseView{

    }
}
