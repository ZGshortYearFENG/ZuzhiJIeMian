package com.example.key.zuzhi.itemviewbinder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.key.zuzhi.R;
import com.example.key.zuzhi.item.FeatureItem;
import com.example.key.zuzhi.item.HeaderItem;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by key on 2018/5/6.
 */

public class HeaderItemViewBinder extends ItemViewBinder<HeaderItem, HeaderItemViewBinder.HeaderItemViewHolder> {

    static class HeaderItemViewHolder extends RecyclerView.ViewHolder {

        private TextView header;

        HeaderItemViewHolder(View itemView) {
            super(itemView);
            this.header = (TextView) itemView.findViewById(R.id.header);
        }
    }

    @NonNull
    @Override
    protected HeaderItemViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new HeaderItemViewHolder(inflater.inflate(R.layout.item_header, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull HeaderItemViewHolder holder, @NonNull HeaderItem item) {
        holder.header.setText(item.header);
    }
}
