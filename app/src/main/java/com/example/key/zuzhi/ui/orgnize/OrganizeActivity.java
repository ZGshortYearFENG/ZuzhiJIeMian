package com.example.key.zuzhi.ui.orgnize;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.key.zuzhi.R;
import com.example.key.zuzhi.event.LeaderMessageEvent;
import com.example.key.zuzhi.network.RetrofitClient;
import com.example.key.zuzhi.ui.orgnize.deparment.DeparmentFragment;
import com.example.key.zuzhi.ui.orgnize.job.JobFragment;
import com.example.key.zuzhi.ui.base.BaseActivity;
import com.example.key.zuzhi.ui.orgnize.leader.LeaderFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.Items;

public class OrganizeActivity extends BaseActivity implements OrgnizeContract.View {

    private static final String TAG = "OrganizeActivity";

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private Items mItems = new Items();
    private List<Fragment> fragments = new ArrayList<>();

    private OrgnizeContract.Presenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organize);

        new OrgnizePresenter(this).subscribe();

        setupTabLayout();

    }

    private void setupTabLayout() {
        mTabLayout = findViewById(R.id.organize_tab);
        mViewPager = findViewById(R.id.organize_viewpager);

        fragments.add(new LeaderFragment());
        fragments.add(new DeparmentFragment());
        fragments.add(new JobFragment());

        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });

        // 预加载
        mViewPager.setOffscreenPageLimit(fragments.size());
        mTabLayout.setupWithViewPager(mViewPager);

        // Tab
        String[] texts = new String[]{"领导分工","部门职责","岗位职责"};
        for (int i = 0; i < mTabLayout.getTabCount(); i++) {
            mTabLayout.getTabAt(i).setText(texts[i]);
        }
    }

    // MVP

    @Override
    public void setPresenter(OrgnizeContract.Presenter presenter) {
        mPresenter = presenter;
    }



    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLeaderMessageEvent(LeaderMessageEvent event) {
        mViewPager.setCurrentItem(event.item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
