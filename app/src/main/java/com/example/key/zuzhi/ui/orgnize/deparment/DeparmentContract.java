package com.example.key.zuzhi.ui.orgnize.deparment;

import com.example.key.zuzhi.ui.base.BasePresenter;
import com.example.key.zuzhi.ui.base.BaseView;
import com.example.key.zuzhi.ui.orgnize.job.JobContract;

import me.drakeet.multitype.Items;

public class DeparmentContract {

    interface View extends BaseView<DeparmentContract.Presenter> {

        void onLoaded(Items items);
    }

    interface Presenter extends BasePresenter {

        void load();
    }
}
