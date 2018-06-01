package com.example.key.zuzhi.ui.orgnize.deparment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.key.zuzhi.R;
import com.example.key.zuzhi.data.Resource;
import com.example.key.zuzhi.databinding.FragmentDeparmentBinding;
import com.example.key.zuzhi.item.DeparmentDetailItem;
import com.example.key.zuzhi.item.DeparmentItem;
import com.example.key.zuzhi.itemviewbinder.DeparmentDetailItemViewBinder;
import com.example.key.zuzhi.itemviewbinder.DeparmentItemViewBinder;
import com.example.key.zuzhi.ui.base.BaseFragment;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

public class DeparmentFragment extends BaseFragment implements DeparmentContract.View {

    public FragmentDeparmentBinding databinding;
    public MultiTypeAdapter mAdapter = new MultiTypeAdapter();
    public DeparmentContract.Presenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        databinding = DataBindingUtil.inflate(inflater, R.layout.fragment_deparment, container, false);

        mAdapter.register(DeparmentItem.class, new DeparmentItemViewBinder());
        mAdapter.register(DeparmentDetailItem.class, new DeparmentDetailItemViewBinder());
        databinding.recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        databinding.recyclerview.setAdapter(mAdapter);

        return databinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        new DeparmentPresenter(this).subscribe();
        mPresenter.load();
    }

    // MVP

    @Override
    public void onLoaded(Items items) {
//        databinding.setResource(items);
        databinding.setItems(items);
    }

    @Override
    public void setPresenter(DeparmentContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
