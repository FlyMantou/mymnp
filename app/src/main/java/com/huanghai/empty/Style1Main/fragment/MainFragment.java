package com.huanghai.empty.Style1Main.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.hpw.mvpframe.base.CoreBaseActivity;
import com.hpw.mvpframe.base.CoreBaseFragment;
import com.hpw.mvpframe.utils.SpUtil;
import com.hpw.mvpframe.utils.helper.FragmentAdapter;
import com.huanghai.empty.Constants;
import com.huanghai.empty.R;
import com.huanghai.empty.Style1Main.contract.MainContract;
import com.huanghai.empty.Style1Main.fragment.child.Fragment1;
import com.huanghai.empty.Style1Main.fragment.child.Fragment2;
import com.huanghai.empty.Style1Main.fragment.child.Fragment3;
import com.huanghai.empty.Style1Main.fragment.child.Fragment4;
import com.huanghai.empty.Style1Main.fragment.child.Fragment5;
import com.huanghai.empty.Style1Main.model.MainModel;
import com.huanghai.empty.Style1Main.presenter.MainPresenter;
import com.huanghai.empty.aboutme.AboutMeActivity;
import com.huanghai.empty.zhihu.contract.ZhihuContract;
import com.huanghai.empty.zhihu.fragment.child.DailyFragment;
import com.huanghai.empty.zhihu.fragment.child.QuickFragment;
import com.huanghai.empty.zhihu.fragment.child.SectionFragment;
import com.huanghai.empty.zhihu.fragment.child.WechatFragment;
import com.huanghai.empty.zhihu.model.ZhihuMainModel;
import com.huanghai.empty.zhihu.presenter.ZhihuMainPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by hpw on 16/10/31.
 */
public class MainFragment extends CoreBaseFragment<MainPresenter, MainModel> implements MainContract.MainView, Toolbar.OnMenuItemClickListener {
   // protected OnFragmentOpenDrawerListener mOpenDraweListener;
    List<Fragment> fragments = new ArrayList<>();
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
   /* @BindView(R.id.fab)
    FloatingActionButton fab;*/
    @Override
    public int getLayoutId() {
        return R.layout.app_bar_main;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        /*if (context instanceof OnFragmentOpenDrawerListener) {
            mOpenDraweListener = (OnFragmentOpenDrawerListener) context;
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //mOpenDraweListener = null;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.day) {//关于我
           // SpUtil.setNightModel(mContext, false);
            //((CoreBaseActivity) getActivity()).reload();
           getActivity().startActivity(new Intent(getActivity(), AboutMeActivity.class));
            return true;
        }
        return false;
    }



    public static MainFragment newInstance(int position) {
        MainFragment fragment = new MainFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Constants.ARG_POSITION, position);
        fragment.setArguments(bundle);
        return fragment;
    }



    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {
        toolbar.setTitle("首页");
        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
        toolbar.setNavigationOnClickListener(v -> {
           // if (mOpenDraweListener != null) {
             //   mOpenDraweListener.onOpenDrawer();
           // }
        });
        /*fab.setOnClickListener(v -> Snackbar.make(v, "Snackbar comes out", Snackbar.LENGTH_LONG).setAction("action", vi -> {
            showToast("ZhihuMainFragment");
        }));*/
        toolbar.inflateMenu(R.menu.fragment_main_menu);
        toolbar.setOnMenuItemClickListener(this);
    }

    @Override
    public void showTabList(String[] mTabs,int[] mTabsIcons) {
        //TabLayout配合ViewPager有时会出现不显示Tab文字的Bug,需要按如下顺序
        for (int i = 0; i < mTabs.length; i++) {
            /*TabLayout.Tab tab=tabs.newTab();
            View view= LayoutInflater.from(getActivity()).inflate(R.layout.layout_tabbar_item,null);
            TextView tv= (TextView) view.findViewById(R.id.main_tv);
            tv.setText(mTabs[i]);
            view.findViewById(R.id.img).setBackgroundResource(mTabsIcons[i]);

            tab.setCustomView(view);
            if (i==0)
                tv.setFocusable(true);*/



           tabs.addTab(tabs.newTab().setText(mTabs[i]).setIcon(mTabsIcons[i]));

            switch (i) {
                case 0:
                    fragments.add(new Fragment1());
                    break;
                case 1:
                    fragments.add(new Fragment2());
                    break;
                case 2:
                    fragments.add(new Fragment3());
                    break;
                case 3:
                    fragments.add(new Fragment4());
                    break;
                default:
                    fragments.add(new Fragment5());
                    break;
            }
        }
        int position = getArguments().getInt(Constants.ARG_POSITION, 1);
        viewpager.setAdapter(new FragmentAdapter(getChildFragmentManager(), fragments));
        viewpager.setCurrentItem(position);//要设置到viewpager.setAdapter后才起作用
        tabs.setupWithViewPager(viewpager);
        tabs.setVerticalScrollbarPosition(position);
        for (int i = 0; i < mTabs.length; i++) {
            tabs.getTabAt(i).setText(mTabs[i]).setIcon(mTabsIcons[i]);
       }
    }

    @Override
    public void showError(String msg) {

    }
}
