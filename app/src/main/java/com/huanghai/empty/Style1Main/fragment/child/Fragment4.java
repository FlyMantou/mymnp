package com.huanghai.empty.Style1Main.fragment.child;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.myhuanghai.mvpcore.base.CoreBaseFragment;
import com.myhuanghai.mvpcore.widget.recyclerview.BaseQuickAdapter;
import com.myhuanghai.mvpcore.widget.recyclerview.BaseViewHolder;
import com.myhuanghai.mvpcore.widget.recyclerview.CoreRecyclerView;
import com.myhuanghai.mvpcore.widget.recyclerview.listener.OnItemClickListener;
import com.myhuanghai.mvpcore.widget.recyclerview.recyclerviewpager.LoopRecyclerViewPager;
import com.huanghai.empty.R;
import com.huanghai.empty.zhihu.activity.ZhihuDetailsActivity;
import com.huanghai.empty.zhihu.contract.ZhihuContract;
import com.huanghai.empty.zhihu.model.dailymodel.DailyListBean;
import com.huanghai.empty.zhihu.model.dailymodel.DailyModel;
import com.huanghai.empty.zhihu.presenter.dailypresenter.DailyPresenter;


/**
 * Created by hpw on 16/10/31.
 */
public class Fragment4 extends CoreBaseFragment<DailyPresenter, DailyModel> implements ZhihuContract.DailyView {
    CoreRecyclerView coreRecyclerView;
    LoopRecyclerViewPager vpTop;

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public View getLayoutView() {
        TextView textView = new TextView(mContext);
        textView.setText("Fragment4");
        return textView;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {

    }

    @Override
    public void initData() {

    }

    @Override
    public void showContent(DailyListBean info) {

    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void doInterval(int i) {

    }
}
