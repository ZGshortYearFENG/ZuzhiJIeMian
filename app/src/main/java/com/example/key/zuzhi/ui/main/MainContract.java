package com.example.key.zuzhi.ui.main;

import com.example.key.zuzhi.ui.base.BasePresenter;
import com.example.key.zuzhi.ui.base.BaseView;

public class MainContract {

    interface View extends BaseView<MainContract.Presenter> {

    }

    interface Presenter extends BasePresenter {

        void login();
    }
}
