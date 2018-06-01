package com.example.key.zuzhi.data.model;

import java.util.List;

public class Select {


    /**
     * currentPage : 1
     * pageSize : 3
     * tableName : org_1_1
     * data : [{"A_5":"1"}]
     */

    public int currentPage;
    public int pageSize;
    public String tableName;
    public List<DataBean> data;

    public Select(int currentPage, int pageSize, String tableName, List<DataBean> data) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.tableName = tableName;
        this.data = data;
    }

    public static class DataBean {
        /**
         * A_5 : 1
         */

        public String A_5;

        public DataBean(String A_5) {
            this.A_5 = A_5;
        }
    }
}
