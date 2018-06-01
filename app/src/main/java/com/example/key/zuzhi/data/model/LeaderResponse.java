package com.example.key.zuzhi.data.model;

import java.util.List;

public class LeaderResponse {

    public boolean success;
    public String msg;
    public List<ObjBean> obj;

    public LeaderResponse(boolean success, String msg, List<ObjBean> obj) {
        this.success = success;
        this.msg = msg;
        this.obj = obj;
    }

    public static class ObjBean {

        public String A_7_1;
        public String A_7_2;
        public String A_6_9;
        public String A_7_3;
        public String A_6_8;
        public String A_7_4;
        public String A_6_7;
        public String A_6_6;
        public String A_6_5;
        public String A_6_4;
        public String A_1;
        public String A_6_3;
        public String A_2;
        public String A_6_2;
        public String A_6_1;
        public String A_4;
        public String A_3_2;
        public String A_5;
        public String A_3_1;
        public String A_6_10;
        public int id;
        public int delstatus;

    }
}
