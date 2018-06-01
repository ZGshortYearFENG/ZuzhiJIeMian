package com.example.key.zuzhi.ui.orgnize.leader;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.key.zuzhi.R;
import com.example.key.zuzhi.item.DisplayDetailItem;
import com.example.key.zuzhi.item.DisplayItem;
import com.example.key.zuzhi.item.LeaderItem;
import com.example.key.zuzhi.itemviewbinder.DisplayDetailViewBinder;
import com.example.key.zuzhi.itemviewbinder.DisplayViewBinder;
import com.example.key.zuzhi.itemviewbinder.LeaderItemViewBinder;
import com.example.key.zuzhi.network.RetrofitClient;
import com.example.key.zuzhi.ui.base.BaseFragment;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

public class LeaderFragment extends BaseFragment implements LeaderContract.View {

    private MultiTypeAdapter mAdapter = new MultiTypeAdapter();
    private RecyclerView mRecyclerView;

    private Items mItem = new Items();

    private LeaderContract.Presenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_leader,null);
        mRecyclerView = view.findViewById(R.id.leader_recyclerview);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAdapter.register(LeaderItem.class,new LeaderItemViewBinder());
        mAdapter.register(DisplayDetailItem.class , new DisplayDetailViewBinder(getContext()));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter.setItems(mItem);
        mAdapter.notifyDataSetChanged();

        new LeaderPresenter(this).subscribe();
        mPresenter.load();
    }



    // MVP

    @Override
    public void setPresenter(LeaderContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onLoaded(Items items) {
        mItem.clear();
        mItem.addAll(items);
        mAdapter.setItems(mItem);
        mAdapter.notifyDataSetChanged();
    }
}
