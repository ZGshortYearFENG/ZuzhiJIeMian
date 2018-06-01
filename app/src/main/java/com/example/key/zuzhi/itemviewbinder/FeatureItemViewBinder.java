package com.example.key.zuzhi.itemviewbinder;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.key.zuzhi.R;
import com.example.key.zuzhi.item.FeatureItem;
import com.example.key.zuzhi.ui.orgnize.OrganizeActivity;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by key on 2018/5/6.
 */

public class FeatureItemViewBinder extends ItemViewBinder<FeatureItem, FeatureItemViewBinder.FeatureItemViewHolder> {

    static class FeatureItemViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private ImageView image;
        private LinearLayout layout;

        FeatureItemViewHolder(View itemView) {
            super(itemView);
            this.name = (TextView) itemView.findViewById(R.id.feature_name);
            this.image = (ImageView) itemView.findViewById(R.id.feature_image);
            this.layout = (LinearLayout) itemView.findViewById(R.id.feature);
        }
    }

    private Context mContext;

    public FeatureItemViewBinder(Context context) {
        super();
        mContext = context;
    }

    @NonNull
    @Override
    protected FeatureItemViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new FeatureItemViewHolder(inflater.inflate(R.layout.item_feature, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull FeatureItemViewHolder holder, @NonNull FeatureItem item) {
        holder.name.setText(item.featureName);
        holder.image.setImageResource(item.featureImage);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, OrganizeActivity.class));
            }
        });
    }
}
