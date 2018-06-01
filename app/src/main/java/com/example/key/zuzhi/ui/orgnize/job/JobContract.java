package com.example.key.zuzhi.ui.orgnize.job;

import com.example.key.zuzhi.ui.base.BasePresenter;
import com.example.key.zuzhi.ui.base.BaseView;

import me.drakeet.multitype.Items;

public class JobContract {

    interface View extends BaseView<JobContract.Presenter> {

        void onLoaded(Items items);
    }

    interface Presenter extends BasePresenter {

        void load();
    }
}
