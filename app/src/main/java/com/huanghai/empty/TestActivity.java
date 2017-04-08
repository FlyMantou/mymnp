package com.huanghai.empty;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.hpw.mvpframe.R2;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by huanghai on 2017/4/7.
 */

public class TestActivity extends Activity {

    @BindView(R.id.text)
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        textView.setText("huanghai");
    }
}
