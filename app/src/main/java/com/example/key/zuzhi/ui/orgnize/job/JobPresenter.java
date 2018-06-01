package com.example.key.zuzhi.ui.orgnize.job;

import android.util.Log;

import com.example.key.zuzhi.data.Injection;
import com.example.key.zuzhi.data.model.JobResponse;
import com.example.key.zuzhi.data.source.remote.RemoteLeaderDataSource;
import com.example.key.zuzhi.item.JobItem;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import me.drakeet.multitype.Items;

public class JobPresenter implements JobContract.Presenter {

    private static final String TAG = "JobPresenter";

    private JobContract.View mView;
    private RemoteLeaderDataSource mRemote;
    private CompositeDisposable mSubscriptions;

    public JobPresenter(JobContract.View view) {
        mView = view;
        mView.setPresenter(this);
        mRemote = new RemoteLeaderDataSource(Injection.provideRESTfulApi());
        mSubscriptions = new CompositeDisposable();
    }

    @Override
    public void load() {
        mRemote.getJobTable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JobResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: ");
                    }

                    @Override
                    public void onNext(JobResponse selectResponse) {
                        Log.d(TAG, "onNext: ");

                        Items items = new Items();
                        for (JobResponse.ObjBean s : selectResponse.obj) {
                            items.add(new JobItem(s, false));
                        }
                        mView.onLoaded(items);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e.getMessage());
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
