package com.example.key.zuzhi.item;

import com.example.key.zuzhi.data.model.DeparmentResponse;

public class DeparmentItem {

    public DeparmentResponse.ObjBean objBean;
    public boolean isExpand;

    public DeparmentItem(DeparmentResponse.ObjBean objBean, boolean isExpand) {
        this.objBean = objBean;
        this.isExpand = isExpand;
    }
}
