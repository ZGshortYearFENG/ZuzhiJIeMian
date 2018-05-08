package com.example.key.zuzhi.organize;

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
import com.example.key.zuzhi.item.orgnize.DisplayDetailItem;
import com.example.key.zuzhi.item.orgnize.DisplayItem;
import com.example.key.zuzhi.itemviewbinder.orgnize.DisplayDetailViewBinder;
import com.example.key.zuzhi.itemviewbinder.orgnize.DisplayViewBinder;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

public class LeaderFragment extends Fragment {

    private MultiTypeAdapter mAdapter = new MultiTypeAdapter();
    private RecyclerView mRecyclerView;

    private Items mItem = new Items();

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

        mAdapter.register(DisplayItem.class,new DisplayViewBinder());
        mAdapter.register(DisplayDetailItem.class , new DisplayDetailViewBinder(getContext()));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(layoutManager);


        for (int i = 0; i < 20; i++) {
            mItem.add(new DisplayItem("朱天乐" + i ,"贪玩蓝月" + i ,null,false ));
        }

        mAdapter.setItems(mItem);
        mAdapter.notifyDataSetChanged();

    }
}
