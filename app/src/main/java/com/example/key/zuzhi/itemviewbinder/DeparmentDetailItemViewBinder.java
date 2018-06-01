package com.example.key.zuzhi.itemviewbinder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.key.zuzhi.databinding.ItemDeparmentDetailBinding;
import com.example.key.zuzhi.item.DeparmentDetailItem;
import com.example.key.zuzhi.item.DeparmentItem;

import java.util.ArrayList;

import me.drakeet.multitype.ItemViewBinder;

public class DeparmentDetailItemViewBinder extends ItemViewBinder<DeparmentDetailItem, DeparmentDetailItemViewBinder.DeparmentDetailItemViewHolder> {

    static class DeparmentDetailItemViewHolder extends RecyclerView.ViewHolder {

        public static DeparmentDetailItemViewHolder create(LayoutInflater inflater, ViewGroup parent) {
            ItemDeparmentDetailBinding databinding = ItemDeparmentDetailBinding.inflate(inflater, parent, false);
            return new DeparmentDetailItemViewHolder(databinding);
        }

        ItemDeparmentDetailBinding databinding;

        public DeparmentDetailItemViewHolder(ItemDeparmentDetailBinding databinding) {
            super(databinding.getRoot());
            this.databinding = databinding;
        }

        public void onBind(DeparmentDetailItem item) {
            databinding.setBean(item.objBean);

            StringBuilder builder = new StringBuilder();
            ArrayList<String> list = new ArrayList<>();
            list.add(item.objBean.A_7_1);
            list.add(item.objBean.A_7_2);
            list.add(item.objBean.A_7_3);
            list.add(item.objBean.A_7_4);
            list.add(item.objBean.A_7_5);
            list.add(item.objBean.A_7_6);
            list.add(item.objBean.A_7_7);
            list.add(item.objBean.A_7_8);
            list.add(item.objBean.A_7_9);
            list.add(item.objBean.A_7_10);

            for (String s : list) {
                if (!TextUtils.isEmpty(s)) {
                    builder.append(s + "\n");
                }
            }
            databinding.deparment1.setText(builder.toString());


            StringBuilder builder1 = new StringBuilder();
            ArrayList<String> list1 = new ArrayList<>();
            list1.add(item.objBean.A_11_1);
            list1.add(item.objBean.A_11_2);
            list1.add(item.objBean.A_11_3);
            list1.add(item.objBean.A_11_4);
            list1.add(item.objBean.A_11_5);

            for (String s : list1) {
                if (!TextUtils.isEmpty(s)) {
                    builder1.append(s + "\n");
                }
            }
            databinding.job1.setText(builder1.toString());
        }
    }

    @NonNull
    @Override
    protected DeparmentDetailItemViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return DeparmentDetailItemViewHolder.create(inflater, parent);
    }

    @Override
    protected void onBindViewHolder(@NonNull DeparmentDetailItemViewHolder holder, @NonNull DeparmentDetailItem item) {
        holder.onBind(item);
    }
}
