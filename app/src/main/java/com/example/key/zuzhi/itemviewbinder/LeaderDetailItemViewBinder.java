package com.example.key.zuzhi.itemviewbinder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.key.zuzhi.R;
import com.example.key.zuzhi.item.LeaderItem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.drakeet.multitype.ItemViewBinder;

public class LeaderDetailItemViewBinder extends ItemViewBinder<LeaderItem, LeaderDetailItemViewBinder.LeaderDetailItemViewHolder> {

    private static final String TAG = "LeaderDetailItemViewBin";

    static class LeaderDetailItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.leader_detail_zhize)
        TextView zhize;
        @BindView(R.id.leader_detail_deparment)
        TextView deparment;

        LeaderDetailItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @NonNull
    @Override
    protected LeaderDetailItemViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new LeaderDetailItemViewHolder(inflater.inflate(R.layout.item_leader_detail, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull LeaderDetailItemViewHolder holder, @NonNull LeaderItem item) {
        StringBuilder builder = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        list.add(item.response.A_6_1);
        list.add(item.response.A_6_2);
        list.add(item.response.A_6_3);
        list.add(item.response.A_6_4);
        list.add(item.response.A_6_5);
        list.add(item.response.A_6_6);
        list.add(item.response.A_6_7);
        list.add(item.response.A_6_8);
        list.add(item.response.A_6_9);
        list.add(item.response.A_6_10);

        for (String s : list) {
            if (!TextUtils.isEmpty(s)) {
                builder.append(s).append("\n");
            }
        }

        StringBuilder builder1 = new StringBuilder();
        ArrayList<String> list1 = new ArrayList<>();
        list1.add(item.response.A_7_1);
        list1.add(item.response.A_7_2);
        list1.add(item.response.A_7_3);
        list1.add(item.response.A_7_4);

        for (String s : list1) {
            if (!TextUtils.isEmpty(s)) {
                builder1.append(s).append("\n");
            }
        }
        holder.zhize.setText(builder.toString());
        holder.deparment.setText(builder1.toString());

    }
}
