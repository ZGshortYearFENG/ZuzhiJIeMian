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
import com.example.key.zuzhi.item.LeaderItem;
import com.example.key.zuzhi.itemviewbinder.LeaderDetailItemViewBinder;
import com.example.key.zuzhi.itemviewbinder.LeaderItemViewBinder;
import com.example.key.zuzhi.ui.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.drakeet.multitype.ClassLinker;
import me.drakeet.multitype.ItemViewBinder;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

public class LeaderFragment extends BaseFragment implements LeaderContract.View {

    MultiTypeAdapter mAdapter = new MultiTypeAdapter();
    Items mItem = new Items();

    LeaderContract.Presenter mPresenter = new LeaderPresenter(this);

    @BindView(R.id.leader_recyclerview)
    RecyclerView mRecyclerView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_leader,null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        mAdapter.register(LeaderItem.class).to(
                new LeaderItemViewBinder(),
                new LeaderDetailItemViewBinder()
        ).withClassLinker(new ClassLinker<LeaderItem>() {
            @NonNull
            @Override
            public Class<? extends ItemViewBinder<LeaderItem, ?>> index(int position, @NonNull LeaderItem leaderItem) {
                if (leaderItem.type == LeaderItem.Leader_Item) {
                    return LeaderItemViewBinder.class;
                } else {
                    return LeaderDetailItemViewBinder.class;
                }
            }
        });
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter.setItems(mItem);
        mAdapter.notifyDataSetChanged();

        // Load Data
        mPresenter.subscribe();
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
