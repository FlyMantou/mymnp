package com.huanghai.empty.Style1Main.model;

import com.huanghai.empty.R;
import com.huanghai.empty.Style1Main.contract.MainContract;

/**
 * Created by huanghai on 2017/4/8.
 */

public class MainModel implements MainContract.MainModel {
    @Override
    public String[] getTabs() {
        String[] mTabs = {"教学楼", "操场", "食堂", "商店","宿舍"};
        return mTabs;//暂时不从网络取
    }

    @Override
    public int[] getTabsIcon() {
        int[] mTabsIcons = {R.drawable.r_1,R.drawable.r_2,R.drawable.r_3,R.drawable.r_4,R.drawable.r_5};
        return mTabsIcons;
    }
}
