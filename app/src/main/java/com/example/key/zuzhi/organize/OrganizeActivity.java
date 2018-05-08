package com.example.key.zuzhi.organize;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.key.zuzhi.R;

import me.drakeet.multitype.Items;

public class OrganizeActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private Items mItems = new Items();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organize);

        mTabLayout = findViewById(R.id.organize_tab);
        mViewPager = findViewById(R.id.organize_viewpager);

        //先adapter
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return new LeaderFragment();
            }

            @Override
            public int getCount() {
                return 3;
            }
        });

        mTabLayout.setupWithViewPager(mViewPager);

        String[] texts = new String[]{"领导分工","部门职责","岗位职责"};

        for (int i = 0; i < mTabLayout.getTabCount(); i++) {
            mTabLayout.getTabAt(i).setText(texts[i]);
        }





    }
}
