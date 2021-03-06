package com.huanghai.empty.Style1Main.contract;

import com.myhuanghai.mvpcore.base.CoreBaseModel;
import com.myhuanghai.mvpcore.base.CoreBasePresenter;
import com.myhuanghai.mvpcore.base.CoreBaseView;

/**
 * Created by huanghai on 2017/4/8.
 */

public interface MainContract {
     abstract class MainPresenter extends CoreBasePresenter<MainModel,MainView>{
         public abstract void getTabList();
    }
    interface MainModel extends CoreBaseModel{
        String[] getTabs();
        int[] getTabsIcon();
    }
    interface MainView extends CoreBaseView{
        void showTabList(String[] mTabs,int[] mTabsIcons);
    }
}
