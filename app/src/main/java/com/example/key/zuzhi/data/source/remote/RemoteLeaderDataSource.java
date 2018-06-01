package com.example.key.zuzhi.data.source.remote;

import com.example.key.zuzhi.data.model.DeparmentResponse;
import com.example.key.zuzhi.data.model.JobResponse;
import com.example.key.zuzhi.data.model.LeaderResponse;
import com.example.key.zuzhi.data.model.Select;
import com.example.key.zuzhi.data.source.remote.api.RESTFulApiService;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import okhttp3.ResponseBody;

public class RemoteLeaderDataSource extends AbstractRemoteDataSource {

    private static final String TAG = "RemoteLeaderDataSource";

    public RemoteLeaderDataSource(RESTFulApiService api) {
        super(api);
    }

    public Observable<String> login() {
        return mApi.login("k", "123456")
                .flatMap(new Function<ResponseBody, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(ResponseBody responseBody) throws Exception {
                        return Observable.just(responseBody.string());
                    }
                });
    }

    public Observable<String> getTables() {
        return mApi.getAllTables()
                .flatMap(new Function<ResponseBody, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(ResponseBody responseBody) throws Exception {
                        return Observable.just(responseBody.string());
                    }
                });
    }

    // org_1_1
    public Observable<LeaderResponse> getLeaderTable() {
        List<Select.DataBean> list = new ArrayList<>();
        Select select = new Select(1, 10, "org_1_1", list);
        return mApi.selected1(select);
    }

    // org_1_2
    public Observable<DeparmentResponse> getDeparmentTable() {
        List<Select.DataBean> list = new ArrayList<>();
        Select select = new Select(1, 10, "org_1_2", list);
        return mApi.selected2(select);
    }

    // org_1_3
    public Observable<JobResponse> getJobTable() {
        List<Select.DataBean> list = new ArrayList<>();
        Select select = new Select(1, 10, "org_1_3", list);
        return mApi.selected3(select);
    }

}
