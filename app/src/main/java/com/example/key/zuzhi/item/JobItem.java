package com.example.key.zuzhi.item;

import com.example.key.zuzhi.data.model.JobResponse;

public class JobItem {

    public JobResponse.ObjBean response;
    public boolean isExpand;

    public JobItem(JobResponse.ObjBean response, boolean isExpand) {
        this.response = response;
        this.isExpand = isExpand;
    }
}
