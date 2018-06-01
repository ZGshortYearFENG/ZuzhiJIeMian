package com.example.key.zuzhi.ui.orgnize.leader;

import com.example.key.zuzhi.ui.base.BasePresenter;
import com.example.key.zuzhi.ui.base.BaseView;

import me.drakeet.multitype.Items;

public class LeaderContract {

    interface View extends BaseView<Presenter> {

        void onLoaded(Items items);
    }

    interface Presenter extends BasePresenter {

        void load();
    }
}
