package com.example.key.zuzhi.network;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Header;

public class RetrofitClient {

    public static String cookie;

    private static final String TAG = "RetrofitClient";

    public static Retrofit defaultInstance() {
        return new Retrofit.Builder()
                .client(defaultOkHttpClient())
                .baseUrl(ServerConfig.TEST_API_HOST)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static OkHttpClient defaultOkHttpClient() {
        return new OkHttpClient.Builder()
                .addNetworkInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {

//                        Request request;
//                        Response response;
//
//                        // 查看是否保存
//                        if (cookie != null) {
//                            Request.Builder builder = chain.request().newBuilder()
//                                    .addHeader("Cookie", cookie);
//                            request = builder.build();
//                            Log.d(TAG, "intercept: 第一个if " + cookie + " url = " + request.url());
//
//                            String url = request.url().toString();
//
//                            // login 后自动请求一次
//                            if (url.contains("jsessionid")) {
//                                int a = url.indexOf("=");
//                                String session = url.substring(a + 1);
//                                Log.d(TAG, "intercept: session = " + session);
//                                cookie = "JSESSIONID=" + session;
//                            }
//                        } else {
//                            request = chain.request();
//                            Log.d(TAG, "intercept: 第一个 else url = " + request.url());
//                            Log.d(TAG, "intercept: 第一个 else cookie = " + request.header("Cookie"));
//                        }
//                        response = chain.proceed(request);
//                        if (response.header("Set-Cookie") != null) {
//                            List<String> headers = response.headers("Set-Cookie");
//                            for(String c : headers) {
//                                Log.d(TAG, "intercept: 第二个if " + c);
//                            }
//                            cookie = response.header("Set-Cookie");
//                            // 保存
//                        }
//                        return response;

                        Request request;

                        // TODO 这里逻辑错误，应该是先请求login，从response中得到JSESSIONID，然后之后setCookie
                        request = chain.request();
                        if (request.url().toString().contains("JSESSIONID")) {
                            int a = request.url().toString().indexOf("=");
                            String session = request.url().toString().substring(a + 1);
                            Log.d(TAG, "intercept: session = " + session);
                            cookie = "JSESSIONID=" + session;
                        }

                        if (request.url().toString().contains("login") && request.body() != null) {
                            Log.d(TAG, "intercept: login = " + request.body());
                        }

                        // Add Cookie
                        if (cookie != null) {
                            request = request.newBuilder()
                                    .addHeader("Cookie", cookie)
                                    .build();
                        }
                        Log.d(TAG, "intercept: url = " + request.url().toString());
                        Log.d(TAG, "intercept: cookie = " + cookie);

                        return chain.proceed(request);
                    }
                })
                .build();
    }

    public static Gson defaultGson() {
        return new GsonBuilder()
                .create();
    }

}
