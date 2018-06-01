package com.example.key.zuzhi.itemviewbinder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.key.zuzhi.R;
import com.example.key.zuzhi.item.DisplayDetailItem;
import com.example.key.zuzhi.item.DisplayItem;
import com.example.key.zuzhi.item.JobItem;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.ItemViewBinder;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

public class JobItemViewBinder extends ItemViewBinder<JobItem, JobItemViewBinder.JobItemViewHolder> {

    private static final String TAG = "JobItemViewBinder";

    static class JobItemViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private ViewGroup container;

        JobItemViewHolder(View itemView) {
            super(itemView);
            this.name = (TextView) itemView.findViewById(R.id.display_name);
            this.container = itemView.findViewById(R.id.display_container);
        }
    }

    @NonNull
    @Override
    protected JobItemViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new JobItemViewHolder(inflater.inflate(R.layout.item_display, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull final JobItemViewHolder holder, @NonNull final JobItem item) {
        holder.name.setText(item.response.A_2);
        final MultiTypeAdapter adapter = getAdapter();
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (((Items) adapter.getItems()).get(holder.getAdapterPosition()) instanceof JobItem) {
                    JobItem jobItem = (JobItem) ((Items) adapter.getItems()).get(holder.getAdapterPosition());

                    Log.d(TAG, "onClick: position = " + holder.getAdapterPosition());
                    Log.d(TAG, "onClick: item_name = " + jobItem.response.A_2);
                    Log.d(TAG, "onClick: item_name = " + jobItem.response.A_7_1);
                    Log.d(TAG, "onClick: item_name = " + jobItem.response.A_7_2);

                    if (!jobItem.isExpand) {

                        String[] t = new String[1];
                        String[] c = new String[1];

                        List<String> titles = new ArrayList<>();
                        List<String> contents = new ArrayList<>();
                        titles.add("岗位职责");

                        StringBuilder builder = new StringBuilder();
                        ArrayList<String> list = new ArrayList<>();
                        list.add(jobItem.response.A_7_1);
                        list.add(jobItem.response.A_7_2);
                        list.add(jobItem.response.A_7_3);
                        list.add(jobItem.response.A_7_4);
                        list.add(jobItem.response.A_7_5);
                        list.add(jobItem.response.A_7_6);
                        list.add(jobItem.response.A_7_7);
                        list.add(jobItem.response.A_7_8);
                        list.add(jobItem.response.A_7_9);
                        list.add(jobItem.response.A_7_10);

                        for (String s : list) {
                            if (!TextUtils.isEmpty(s)) {
                                builder.append(s + "\n");
                            }
                        }
                        contents.add(builder.toString());

                        Log.d(TAG, "onClick: content = " + contents);

                        Items items = (Items) (adapter.getItems());
                        items.add(holder.getAdapterPosition() + 1,
                                new DisplayDetailItem(titles.toArray(t), contents.toArray(c)));
                        adapter.notifyItemInserted(holder.getAdapterPosition() + 1);
                        jobItem.isExpand = true;

                    } else {
                        adapter.getItems().remove(holder.getAdapterPosition() + 1);
                        adapter.notifyItemRemoved(holder.getAdapterPosition() + 1);
                        jobItem.isExpand = false;
                    }
                }
            }
        });
    }
}
