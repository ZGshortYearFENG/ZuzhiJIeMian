package com.example.key.zuzhi.ui.orgnize;

import android.util.Log;

import com.example.key.zuzhi.data.Injection;
import com.example.key.zuzhi.data.source.remote.RemoteLeaderDataSource;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class OrgnizePresenter implements OrgnizeContract.Presenter {

    private static final String TAG = "OrgnizePresenter";

    private OrgnizeContract.View mView;
    private RemoteLeaderDataSource mRemote;
    private CompositeDisposable mSubscriptions;


    public OrgnizePresenter(OrgnizeContract.View view) {
        mView = view;
        mView.setPresenter(this);
        mRemote = new RemoteLeaderDataSource(Injection.provideRESTfulApi());
        mSubscriptions = new CompositeDisposable();
    }

    @Override
    public void load() {
        
    }

    @Override
    public void login() {
        // 登录
        mRemote.login()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mSubscriptions.add(d);
                        Log.d(TAG, "onSubscribe: ");
                    }

                    @Override
                    public void onNext(String s) {
                        Log.d(TAG, "onNext: " + s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e);
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: ");
                    }
                });
    }

    @Override
    public void subscribe() {
        Log.d(TAG, "subscribe: ");
    }

    @Override
    public void unsubscribe() {
        mSubscriptions.clear();
        mView = null;
    }
}
