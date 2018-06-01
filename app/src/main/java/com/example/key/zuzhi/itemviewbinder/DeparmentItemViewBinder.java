package com.example.key.zuzhi.itemviewbinder;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.key.zuzhi.databinding.ItemDeparmentBinding;
import com.example.key.zuzhi.item.DeparmentDetailItem;
import com.example.key.zuzhi.item.DeparmentItem;

import me.drakeet.multitype.ItemViewBinder;
import me.drakeet.multitype.Items;

public class DeparmentItemViewBinder extends ItemViewBinder<DeparmentItem, DeparmentItemViewBinder.DeparmentItemViewHolder> {

    static class DeparmentItemViewHolder extends RecyclerView.ViewHolder {

        public static DeparmentItemViewHolder create(LayoutInflater inflater, ViewGroup parent) {
            ItemDeparmentBinding databinding = ItemDeparmentBinding.inflate(inflater, parent, false);
            return new DeparmentItemViewHolder(databinding);
        }

        ItemDeparmentBinding databinding;

        public DeparmentItemViewHolder(ItemDeparmentBinding databinding) {
            super(databinding.getRoot());
            this.databinding = databinding;
        }

        public void onBind(DeparmentItem item) {
            databinding.setObj(item.objBean);
        }
    }

    @NonNull
    @Override
    protected DeparmentItemViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return DeparmentItemViewHolder.create(inflater, parent);
    }

    @Override
    protected void onBindViewHolder(@NonNull final DeparmentItemViewHolder holder, @NonNull final DeparmentItem item) {
        holder.onBind(item);
        holder.databinding.displayContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 判断
                if (!(((Items) getAdapter().getItems()).get(holder.getAdapterPosition()) instanceof DeparmentItem)) {
                    return;
                }

                DeparmentItem deparmentItem = (DeparmentItem) ((Items) getAdapter().getItems()).get(holder.getAdapterPosition());
                if (!deparmentItem.isExpand) {
                    ((Items) getAdapter().getItems()).add(holder.getAdapterPosition() + 1, new DeparmentDetailItem(item.objBean));
                    getAdapter().notifyItemInserted(holder.getAdapterPosition() + 1);
                    deparmentItem.isExpand = true;
                } else {
                    ((Items) getAdapter().getItems()).remove(holder.getAdapterPosition() + 1);
                    getAdapter().notifyItemRemoved(holder.getAdapterPosition() + 1);
                    deparmentItem.isExpand = false;
                }
            }
        });
    }
}
