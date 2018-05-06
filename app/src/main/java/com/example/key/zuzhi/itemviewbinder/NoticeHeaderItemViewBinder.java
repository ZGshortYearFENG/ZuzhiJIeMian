package com.example.key.zuzhi.itemviewbinder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.key.zuzhi.R;
import com.example.key.zuzhi.item.HeaderItem;
import com.example.key.zuzhi.item.NoticeHeaderItem;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by key on 2018/5/6.
 */

public class NoticeHeaderItemViewBinder extends ItemViewBinder<NoticeHeaderItem, NoticeHeaderItemViewBinder.NoticeHeaderItemViewHolder> {

    static class NoticeHeaderItemViewHolder extends RecyclerView.ViewHolder {

        private TextView all;
        private TextView finished;

        NoticeHeaderItemViewHolder(View itemView) {
            super(itemView);
            this.all = (TextView) itemView.findViewById(R.id.notice_header_all);
            this.finished = (TextView) itemView.findViewById(R.id.notice_header_finished);
        }
    }

    @NonNull
    @Override
    protected NoticeHeaderItemViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new NoticeHeaderItemViewHolder(inflater.inflate(R.layout.item_noticeheader, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull NoticeHeaderItemViewHolder holder, @NonNull NoticeHeaderItem item) {
        holder.all.setText("" + item.allTask);
        holder.finished.setText("" + item.finishTask);
    }
}