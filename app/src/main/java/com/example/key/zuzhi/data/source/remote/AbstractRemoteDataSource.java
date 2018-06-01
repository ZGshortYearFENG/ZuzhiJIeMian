package com.example.key.zuzhi.data.source.remote;

import com.example.key.zuzhi.data.source.remote.api.RESTFulApiService;

public abstract class AbstractRemoteDataSource {

    protected RESTFulApiService mApi;

    public AbstractRemoteDataSource(RESTFulApiService api) {
        mApi = api;
    }

}