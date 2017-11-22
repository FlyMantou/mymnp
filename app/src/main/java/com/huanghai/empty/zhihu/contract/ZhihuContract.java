package com.huanghai.empty.zhihu.contract;

import com.myhuanghai.mvpcore.base.CoreBaseModel;
import com.myhuanghai.mvpcore.base.CoreBasePresenter;
import com.myhuanghai.mvpcore.base.CoreBaseView;
import com.huanghai.empty.zhihu.model.dailymodel.DailyListBean;
import com.huanghai.empty.zhihu.model.dailymodel.ZhihuDetailBean;
import com.huanghai.empty.zhihu.model.sectionmodel.SectionChildListBean;
import com.huanghai.empty.zhihu.model.sectionmodel.SectionListBean;
import com.huanghai.empty.zhihu.model.wechatmodel.WXItemBean;

import java.util.List;

import rx.Observable;

/**
 * Created by hpw on 16/10/31.
 */

public interface ZhihuContract {
    //主页接口
    abstract class ZhihuMainPresenter extends CoreBasePresenter<ZhihuMainModel, ZhihuMainView> {//获取tans抽象类
        public abstract void getTabList();
    }

    interface ZhihuMainModel extends CoreBaseModel {//获取tabs数组接口
        String[] getTabs();
    }

    interface ZhihuMainView extends CoreBaseView {//显示tablist接口
        void showTabList(String[] mTabs);
    }

    //daily所有接口(model写在了一起,view presenter分开写)
    abstract class DailyPresenter extends CoreBasePresenter<DailyModel, DailyView> {
        public abstract void getDailyData();//获取日报数据

        public abstract void startInterval();//循环轮播图
    }

    interface DailyModel extends CoreBaseModel {
        Observable<DailyListBean> getDailyData();//获取日常观察对象

        Observable<ZhihuDetailBean> getZhihuDetails(int anInt);//获取日常详情观察对象
    }

    interface DailyView extends CoreBaseView {
        void showContent(DailyListBean info);//显示列表

        void doInterval(int i);//轮播图
    }

    abstract class ZhihuDetailsPresenter extends CoreBasePresenter<DailyModel, ZhihuDetailsView> {
        public abstract void getZhihuDetails(int anInt);//详情抽象类
    }

    interface ZhihuDetailsView extends CoreBaseView {
        void showContent(ZhihuDetailBean info);//显示详情列表数据接口
    }

    //section所有接口
    abstract class SectionPresenter extends CoreBasePresenter<SectionModel, SectionView> {

        public abstract void getSectionData();
    }

    interface SectionModel extends CoreBaseModel {

        Observable<SectionListBean> getSectionData();

        Observable<SectionChildListBean> getSectionListData(int id);
    }

    interface SectionView extends CoreBaseView {
        void showContent(SectionListBean info);

    }

    abstract class SectionListPresenter extends CoreBasePresenter<SectionModel, SectionListView> {

        public abstract void getSectionListData(int id);
    }

    interface SectionListView extends CoreBaseView {
        void showContent(SectionChildListBean info);
    }

    abstract class WechatPresenter extends CoreBasePresenter<WechatModel, WechatView> {
        public abstract void getWechatData(int num, int page);
    }

    interface WechatModel extends CoreBaseModel {
        Observable<List<WXItemBean>> getWechatData(int num, int page);
    }

    interface WechatView extends CoreBaseView {
        void showContent(List<WXItemBean> mList);
    }
}

