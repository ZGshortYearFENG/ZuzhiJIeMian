package com.example.key.zuzhi.data.source.remote.api;

import com.example.key.zuzhi.data.model.DeparmentResponse;
import com.example.key.zuzhi.data.model.JobResponse;
import com.example.key.zuzhi.data.model.LeaderResponse;
import com.example.key.zuzhi.data.model.Select;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RESTFulApiService {

    // 登录
    @FormUrlEncoded
    @POST("/lechang-bpm/loginController/login")
    Observable<ResponseBody> login(@Field("username") String username,@Field("password") String password);

    // 展示所有表
    @GET("/lechang-bpm/cgFormHeadController?showTables")
    Observable<ResponseBody> getAllTables();

    // org_1_1
    @POST("/lechang-bpm/tableCRUDController/select")
    Observable<LeaderResponse> selected1(@Body Select select);

    // org_1_2
    @POST("/lechang-bpm/tableCRUDController/select")
    Observable<DeparmentResponse> selected2(@Body Select select);

    // org_1_3
    @POST("/lechang-bpm/tableCRUDController/select")
    Observable<JobResponse> selected3(@Body Select select);
}
