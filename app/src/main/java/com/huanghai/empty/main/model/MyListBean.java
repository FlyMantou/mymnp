package com.huanghai.empty.main.model;

import java.util.List;

/**
 * Created by huanghai on 2017/4/6.
 */

public class MyListBean {

    private List<DataEntity> data;

    public List<DataEntity> getData() {
        return data;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public static class DataEntity {
        /**
         * ip : 192.168.0.102
         * name : 电信 艾欧尼亚
         * count : 138
         */

        private String ip;
        private String name;
        private int count;

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        @Override
        public String toString() {
            return "DataEntity{" +
                    "ip='" + ip + '\'' +
                    ", name='" + name + '\'' +
                    ", count=" + count +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "MyListBean{" +
                "data=" + data +
                '}';
    }
}
