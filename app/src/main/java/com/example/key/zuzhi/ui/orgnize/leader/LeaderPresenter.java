package com.example.key.zuzhi.ui.orgnize.leader;

import android.util.Log;

import com.example.key.zuzhi.data.Injection;
import com.example.key.zuzhi.data.model.LeaderResponse;
import com.example.key.zuzhi.data.source.remote.RemoteLeaderDataSource;
import com.example.key.zuzhi.item.LeaderItem;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import me.drakeet.multitype.Items;

public class LeaderPresenter implements LeaderContract.Presenter {

    private static final String TAG = "LeaderPresenter";

    private LeaderContract.View mView;
    private RemoteLeaderDataSource mRemote;
    private CompositeDisposable mSubscriptions;

    public LeaderPresenter(LeaderContract.View view) {
        mView = view;
        mView.setPresenter(this);
        mRemote = new RemoteLeaderDataSource(Injection.provideRESTfulApi());
        mSubscriptions = new CompositeDisposable();
    }

    @Override
    public void load() {
        mRemote.getLeaderTable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LeaderResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mSubscriptions.add(d);
                    }

                    @Override
                    public void onNext(LeaderResponse selectResponse) {
                        Items items = new Items();
                        for (LeaderResponse.ObjBean s : selectResponse.obj) {
                            items.add(new LeaderItem(s, false, LeaderItem.Leader_Item));
                        }
                        mView.onLoaded(items);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    @Override
    public void subscribe() {
    }

    @Override
    public void unsubscribe() {
        mSubscriptions.clear();
        mView = null;
    }
}
