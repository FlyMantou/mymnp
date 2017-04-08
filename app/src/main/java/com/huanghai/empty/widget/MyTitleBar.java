package com.huanghai.empty.widget;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.huanghai.empty.App;
import com.huanghai.empty.R;


/**
 * Created by huanghai on 2016/5/26.
 */
public class MyTitleBar extends FrameLayout {

    private LinearLayout ll_menu;
    private TextView tv_title;
    private TextView tv_menu;
    private ImageView iv_menuicon;
    private ImageView back;

    public MyTitleBar(Context context) {
        super(context);
    }

    public MyTitleBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);

    }

    public MyTitleBar(final Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //JLog.i("huanghai","三个参数的");
        View view = View.inflate(context, R.layout.my_titlebar, null);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) (App.SCREEN_HEIGHT * 0.08));
        view.setLayoutParams(params);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TitleBarAttrs);
        String title = ta.getString(R.styleable.TitleBarAttrs_cjyytitle);
        String menuText = ta.getString(R.styleable.TitleBarAttrs_menuText);
        boolean isBackShow = ta.getBoolean(R.styleable.TitleBarAttrs_showBack, true);
        boolean isMenuShow = ta.getBoolean(R.styleable.TitleBarAttrs_showMenu, false);
        Drawable menudrawable = ta.getDrawable(R.styleable.TitleBarAttrs_menuDrawable);

        back = (ImageView) view.findViewById(R.id.back);
        iv_menuicon = (ImageView) view.findViewById(R.id.iv_menuicon);
        tv_title = (TextView) view.findViewById(R.id.tv_title);
        tv_menu = (TextView) view.findViewById(R.id.tv_menu);

        ll_menu = (LinearLayout) view.findViewById(R.id.ll_menu);

        if (title != null) {
            tv_title.setText(title);
        }
        if (isBackShow) {
            back.setVisibility(View.VISIBLE);
            back.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onBackClickListener==null){
                        ((Activity) context).finish();
                    }else {
                        onBackClickListener.onClick();
                    }

                }
            });
        } else {
            back.setVisibility(View.GONE);
        }
        if (isMenuShow) {
            ll_menu.setVisibility(View.VISIBLE);
            if (menudrawable != null) {
                iv_menuicon.setImageDrawable(menudrawable);

            }
            if (menuText != null) {
                tv_menu.setText(menuText);
            }


        } else {
            ll_menu.setVisibility(View.GONE);
        }
        ta.recycle();
        this.addView(view);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MyTitleBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setMenuText(String text) {
        tv_menu.setText(text);
    }

    public void setMenuOnClickListener(View.OnClickListener listener) {
        ll_menu.setOnClickListener(listener);
    }

    public void setBackOnClickListener(View.OnClickListener listener){
        back.setOnClickListener(listener);
    }

    public void setBackVisibility(Boolean visibility){
        if (visibility){
            back.setVisibility(View.VISIBLE);
        } else {
            back.setVisibility(View.GONE);
        }
    }

    public void setMenuVisibilityGone(Boolean gone){
        if (gone){
            ll_menu.setVisibility(GONE);
        } else {
            ll_menu.setVisibility(VISIBLE);
        }
    }

    public void setTitle(String title) {
        tv_title.setText(title);
    }

    public void setMenuIcon(int icon) {
        iv_menuicon.setBackgroundResource(icon);
    }

    public void setIconVisibility(Boolean gone) {
        if (gone) {
            iv_menuicon.setVisibility(VISIBLE);
        } else {
            iv_menuicon.setVisibility(GONE);
        }
    }

    public void setTextVisibility(Boolean gone) {
        if (gone) {
            tv_menu.setVisibility(VISIBLE);
        } else {
            tv_menu.setVisibility(GONE);
        }
    }
    public void setBackVisibility(boolean isShow){
        if(isShow){
            back.setVisibility(View.VISIBLE);
        }else {
            back.setVisibility(View.INVISIBLE);
        }
    }

    public boolean getTextVisibility() {
        if (VISIBLE == tv_menu.getVisibility()) {
            return true;
        }
        return false;
    }

    public boolean getIconVisibility(){
        if (VISIBLE == iv_menuicon.getVisibility()){
            return true;
        }
        return false;
    }

    public interface OnBackClickListener{
        void onClick();
    }

    private OnBackClickListener onBackClickListener;

    public void setOnBackClickListener(OnBackClickListener onBackClickListener) {
        this.onBackClickListener = onBackClickListener;
    }
}
