package com.example.key.zuzhi;

import android.app.Application;

import com.blankj.utilcode.util.Utils;
import com.example.key.zuzhi.network.RetrofitClient;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}
