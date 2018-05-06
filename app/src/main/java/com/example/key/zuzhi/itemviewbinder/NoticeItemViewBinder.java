package com.example.key.zuzhi.itemviewbinder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.key.zuzhi.R;
import com.example.key.zuzhi.item.HeaderItem;
import com.example.key.zuzhi.item.NoticeItem;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by key on 2018/5/6.
 */

public class NoticeItemViewBinder extends ItemViewBinder<NoticeItem, NoticeItemViewBinder.NoticeItemViewHolder> {

    static class NoticeItemViewHolder extends RecyclerView.ViewHolder {

        private TextView task;

        private ImageView image;

        NoticeItemViewHolder(View itemView) {
            super(itemView);
            this.task = (TextView) itemView.findViewById(R.id.notice_task_name);
            this.image = (ImageView) itemView.findViewById(R.id.notice_task_image);
        }
    }

    @NonNull
    @Override
    protected NoticeItemViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new NoticeItemViewHolder(inflater.inflate(R.layout.item_notice, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull NoticeItemViewHolder holder, @NonNull NoticeItem item) {
        holder.task.setText(item.notice);
        holder.image.setImageResource(item.image);
    }
}
