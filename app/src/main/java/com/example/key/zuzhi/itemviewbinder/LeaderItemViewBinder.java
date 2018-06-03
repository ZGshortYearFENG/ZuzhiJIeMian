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

import butterknife.BindView;
import butterknife.ButterKnife;
import me.drakeet.multitype.ItemViewBinder;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

public class LeaderItemViewBinder extends ItemViewBinder<LeaderItem, LeaderItemViewBinder.LeaderItemViewHolder> {

    private static final String TAG = "LeaderItemViewBinder";

    static class LeaderItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.leader_name)
        TextView name;
        @BindView(R.id.leader_container)
        ViewGroup container;

        LeaderItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @NonNull
    @Override
    protected LeaderItemViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new LeaderItemViewHolder(inflater.inflate(R.layout.item_leader_item, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull final LeaderItemViewHolder holder, @NonNull final LeaderItem item) {
        final MultiTypeAdapter adapter = getAdapter();
        holder.name.setText(item.response.A_2);
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (item.type == LeaderItem.Leader_Item) {
                    LeaderItem leaderItem = (LeaderItem) ((Items) adapter.getItems()).get(holder.getAdapterPosition());
                    if (!leaderItem.isExpand) {
                        Items items = (Items) (adapter.getItems());
                        items.add(holder.getAdapterPosition() + 1,
                                new LeaderItem(item.response, item.isExpand, LeaderItem.Leader_Detail));
                        adapter.notifyItemInserted(holder.getAdapterPosition() + 1);
                        leaderItem.isExpand = true;
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
