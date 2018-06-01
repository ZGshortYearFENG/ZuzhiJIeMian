package com.example.key.zuzhi.ui.orgnize;


import com.example.key.zuzhi.ui.base.BasePresenter;
import com.example.key.zuzhi.ui.base.BaseView;

public interface OrgnizeContract {

    interface View extends BaseView<Presenter> {


    }

    interface Presenter extends BasePresenter {

        void load();

        void login();
    }
}

