package com.huanghai.empty.main.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.myhuanghai.mvpcore.base.CoreBaseActivity;
import com.myhuanghai.mvpcore.utils.LogUtil;
import com.myhuanghai.mvpcore.utils.ToastUtils;
import com.myhuanghai.mvpcore.widget.recyclerview.BaseQuickAdapter;
import com.myhuanghai.mvpcore.widget.recyclerview.BaseViewHolder;
import com.myhuanghai.mvpcore.widget.recyclerview.CoreRecyclerView;
import com.myhuanghai.mvpcore.widget.recyclerview.listener.OnItemClickListener;
import com.huanghai.empty.R;
import com.huanghai.empty.main.contract.MyContract;
import com.huanghai.empty.main.model.MyListBean;
import com.huanghai.empty.main.model.MyModel;
import com.huanghai.empty.main.presenter.MyPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends CoreBaseActivity<MyPresenter, MyModel> implements MyContract.MyView {
    private static int pageNum = 10;

    @BindView(R.id.recyclerview)
    CoreRecyclerView coreRecyclerView;
    @BindView(R.id.tv_test)
    TextView tvTest;


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {//初始化页面数据

        coreRecyclerView.init(new BaseQuickAdapter<MyListBean.DataEntity, BaseViewHolder>(R.layout.item_my) {
            @Override
            protected void convert(BaseViewHolder helper, MyListBean.DataEntity item) {
                //glide加载图片
                // Glide.with(mContext).load(item.getPicUrl()).crossFade().into((ImageView) helper.getView(R.id.iv_wechat_item_image));
                helper.setText(R.id.textView, item.getIp())
                        .setText(R.id.textView2, item.getName())
                        .setText(R.id.textView3, item.getCount() + "");

                //  Glide.with(mContext).load(item.getImages().get(0)).crossFade().placeholder(R.mipmap.def_head).into((ImageView) helper.getView(R.id.iv_daily_item_image));
            }
        }).addOnItemClickListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtils.showToast(MainActivity.this, "点击了第：" + position + "条目");
            }
        }).openLoadMore(pageNum, page -> mPresenter.getMybList(pageNum, page))
                .openRefresh();

    }


    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showError(String msg) {

        System.out.print("msg:");
    }

    @Override
    public void showList(MyListBean info) {
        String s = info.toString();
        LogUtil.i("huanghai", s);
        LogUtil.i("huanghai", "--->" + (info == null));
        LogUtil.i("huanghai", "--->" + (coreRecyclerView.getAdapter() == null));

        coreRecyclerView.getAdapter().addData(info.getData());
    }


    @Override
    protected void initData() {
        mPresenter.getMybList(0, 0);
    }


    @OnClick(R.id.tv_test)
    public void onViewClicked() {
        LogUtil.i("huanghai","点击事件");
    }
}
