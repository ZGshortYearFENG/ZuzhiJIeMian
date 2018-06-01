package com.example.key.zuzhi.item;

import com.example.key.zuzhi.data.model.LeaderResponse;

public class LeaderItem {

    public LeaderResponse.ObjBean response;
    public boolean isExpand;

    public LeaderItem(LeaderResponse.ObjBean response, boolean isExpand) {
        this.response = response;
        this.isExpand = isExpand;
    }
}
