package com.huanghai.empty.zhihu.model.quick;


import com.huanghai.empty.zhihu.contract.QuickContract;

import java.util.List;

/**
 * Created by hpw on 16/11/1.
 */

public class QuickModel implements QuickContract.Model {
    @Override
    public List<Status> getData() {
        return DataServer.getSampleData(10);
    }
}
