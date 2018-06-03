package com.example.key.zuzhi.item;

import android.support.annotation.IntDef;

import com.example.key.zuzhi.data.model.LeaderResponse;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class LeaderItem {

    public static final int Leader_Item = 0;
    public static final int Leader_Detail = 1;

    public LeaderResponse.ObjBean response;
    public boolean isExpand;
    public int type;

    public LeaderItem(LeaderResponse.ObjBean response, boolean isExpand, int type) {
        this.response = response;
        this.isExpand = isExpand;
        this.type = type;
    }
}
