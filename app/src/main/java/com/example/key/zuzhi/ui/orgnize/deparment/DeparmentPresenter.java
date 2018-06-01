package com.example.key.zuzhi.ui.orgnize.deparment;

import com.example.key.zuzhi.data.Injection;
import com.example.key.zuzhi.data.model.DeparmentResponse;
import com.example.key.zuzhi.data.source.remote.RemoteLeaderDataSource;
import com.example.key.zuzhi.item.DeparmentItem;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import me.drakeet.multitype.Items;

public class DeparmentPresenter implements DeparmentContract.Presenter {

    private DeparmentContract.View mView;
    private CompositeDisposable mDisposables;
    private RemoteLeaderDataSource mRemote;

    public DeparmentPresenter(DeparmentContract.View view) {
        mView = view;
        mView.setPresenter(this);
        mRemote = new RemoteLeaderDataSource(Injection.provideRESTfulApi());
        mDisposables = new CompositeDisposable();
    }

    @Override
    public void load() {
        mRemote.getDeparmentTable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DeparmentResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposables.add(d);
                    }

                    @Override
                    public void onNext(DeparmentResponse deparmentResponse) {
                        //
                        Items items = new Items();
                        for (DeparmentResponse.ObjBean objBean : deparmentResponse.obj) {
                            items.add(new DeparmentItem(objBean, false));
                        }
                        mView.onLoaded(items);
                    }


                    @Override
                    public void onError(Throwable e) {

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
        mView = null;
        mDisposables.clear();
    }
}
