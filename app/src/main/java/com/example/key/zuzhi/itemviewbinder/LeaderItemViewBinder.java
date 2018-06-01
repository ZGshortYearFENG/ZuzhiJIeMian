package com.example.key.zuzhi.itemviewbinder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.key.zuzhi.R;
import com.example.key.zuzhi.item.DisplayDetailItem;
import com.example.key.zuzhi.item.LeaderItem;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.ItemViewBinder;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

public class LeaderItemViewBinder extends ItemViewBinder<LeaderItem, LeaderItemViewBinder.LeaderItemViewHolder> {

    private static final String TAG = "LeaderItemViewBinder";

    static class LeaderItemViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private ViewGroup container;

        LeaderItemViewHolder(View itemView) {
            super(itemView);
            this.name = (TextView) itemView.findViewById(R.id.display_name);
            this.container = itemView.findViewById(R.id.display_container);
        }
    }

    @NonNull
    @Override
    protected LeaderItemViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new LeaderItemViewHolder(inflater.inflate(R.layout.item_display, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull final LeaderItemViewHolder holder, @NonNull LeaderItem item) {
        holder.name.setText(item.response.A_2);

        final MultiTypeAdapter adapter = getAdapter();
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (((Items) adapter.getItems()).get(holder.getAdapterPosition()) instanceof LeaderItem) {
                    LeaderItem leaderItem = (LeaderItem) ((Items) adapter.getItems()).get(holder.getAdapterPosition());
                    if (!leaderItem.isExpand) {

                        String[] t = new String[2];
                        String[] c = new String[2];

                        List<String> titles = new ArrayList<>();
                        List<String> contents = new ArrayList<>();
                        titles.add("岗位职责");
                        titles.add("下属部门");

                        contents.add(leaderItem.response.A_6_1 + "\n"
                                + leaderItem.response.A_6_2 + "\n"
                                + leaderItem.response.A_6_3);
                        contents.add(leaderItem.response.A_7_1 + "\n"
                                + leaderItem.response.A_7_2 + "\n"
                                + leaderItem.response.A_7_3);

                        Items items = (Items) (adapter.getItems());
                        items.add(holder.getAdapterPosition() + 1,
                                new DisplayDetailItem(titles.toArray(t), contents.toArray(c)));
                        adapter.notifyItemInserted(holder.getAdapterPosition() + 1);
                        leaderItem.isExpand = true;

                        Log.d(TAG, "onClick: t = " + t[0] + t[1]);
                        Log.d(TAG, "onClick: c = " + c[0] + c[1]);

                    } else {
                        adapter.getItems().remove(holder.getAdapterPosition() + 1);
                        adapter.notifyItemRemoved(holder.getAdapterPosition() + 1);
                        leaderItem.isExpand = false;
                    }
                }
            }
        });
    }
}
