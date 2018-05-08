package com.example.key.zuzhi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.key.zuzhi.item.FeatureItem;
import com.example.key.zuzhi.item.HeaderItem;
import com.example.key.zuzhi.item.NoticeHeaderItem;
import com.example.key.zuzhi.item.NoticeItem;
import com.example.key.zuzhi.itemviewbinder.FeatureItemViewBinder;
import com.example.key.zuzhi.itemviewbinder.HeaderItemViewBinder;
import com.example.key.zuzhi.itemviewbinder.NoticeHeaderItemViewBinder;
import com.example.key.zuzhi.itemviewbinder.NoticeItemViewBinder;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MultiTypeAdapter mAdapter;
    private Items mItems = new Items();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initRecyclerView();

    }

    private void initView() {
        mRecyclerView = findViewById(R.id.recycler_view);
    }

    private void initRecyclerView() {
        mAdapter = new MultiTypeAdapter();
        mAdapter.register(HeaderItem.class, new HeaderItemViewBinder());
        mAdapter.register(FeatureItem.class, new FeatureItemViewBinder());
        mAdapter.register(NoticeHeaderItem.class, new NoticeHeaderItemViewBinder());
        mAdapter.register(NoticeItem.class, new NoticeItemViewBinder());
        GridLayoutManager layoutManager = new GridLayoutManager(this, 4);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position > 0 && position < 7) {
                    return 1;
                }
                return 4;
            }
        });
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);

        // Data
        mItems.add(new HeaderItem("功能"));
        mItems.add(new FeatureItem("组织分工", R.drawable.timg));
        mItems.add(new FeatureItem("任务计划", R.drawable.timg));
        mItems.add(new FeatureItem("员工管理", R.drawable.timg));
        mItems.add(new FeatureItem("费用管理", R.drawable.timg));
        mItems.add(new FeatureItem("资料文档", R.drawable.timg));
        mItems.add(new FeatureItem("公告栏", R.drawable.timg));
        mItems.add(new HeaderItem("当日工作台"));


        // TODO 网络请求
        mItems.add(new NoticeHeaderItem(12, 8));

        // task
        for (int i = 0; i < 10; i++) {
            mItems.add(new NoticeItem("任务 " + i, R.drawable.timg));
        }

        mAdapter.setItems(mItems);
        mAdapter.notifyDataSetChanged();
    }

}
