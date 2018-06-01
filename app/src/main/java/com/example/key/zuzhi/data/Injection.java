package com.example.key.zuzhi.data;

import com.example.key.zuzhi.data.source.remote.api.RESTFulApiService;
import com.example.key.zuzhi.network.RetrofitClient;

public class Injection {

    public static RESTFulApiService provideRESTfulApi() {
        return RetrofitClient.defaultInstance().create(RESTFulApiService.class);
    }
}
