package com.huanghai.empty.api;

import com.huanghai.empty.main.model.MyListBean;



import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by huanghai on 2017/4/6.
 */

public interface MainApi {


    /**
     * 加载列表
     */
    @GET("unity")
    Observable<MyListBean> getMyList();


}
