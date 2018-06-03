package com.example.key.zuzhi.itemviewbinder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.key.zuzhi.R;
import com.example.key.zuzhi.item.DeparmentDetailItem;
import com.example.key.zuzhi.item.DeparmentItem;
import com.example.key.zuzhi.view.ExpandableCardView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.drakeet.multitype.ItemViewBinder;
import me.drakeet.multitype.Items;

public class DeparmentItemViewBinder extends ItemViewBinder<DeparmentItem, DeparmentItemViewBinder.DeparmentItemViewHolder> {

    static class DeparmentItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.expand_cardview)
        ExpandableCardView expandableCardView;

        public DeparmentItemViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void onBind(DeparmentItem item) {
            expandableCardView.setTitle(item.objBean.A_2);

            // innterview
            View innerView = expandableCardView.getInnerView();

            // inflate
            TextView deparment = innerView.findViewById(R.id.deparment1);
            TextView job = innerView.findViewById(R.id.job1);

            // set data
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
            deparment.setText(builder.toString());


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
            job.setText(builder1.toString());
        }
    }

    @NonNull
    @Override
    protected DeparmentItemViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new DeparmentItemViewHolder(inflater.inflate(R.layout.item_deparment, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull final DeparmentItemViewHolder holder, @NonNull final DeparmentItem item) {
        holder.onBind(item);
//        holder.databinding.displayContainer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                // 判断
//                if (!(((Items) getAdapter().getItems()).get(holder.getAdapterPosition()) instanceof DeparmentItem)) {
//                    return;
//                }
//
//                DeparmentItem deparmentItem = (DeparmentItem) ((Items) getAdapter().getItems()).get(holder.getAdapterPosition());
//                if (!deparmentItem.isExpand) {
//                    ((Items) getAdapter().getItems()).add(holder.getAdapterPosition() + 1, new DeparmentDetailItem(item.objBean));
//                    getAdapter().notifyItemInserted(holder.getAdapterPosition() + 1);
//                    deparmentItem.isExpand = true;
//                } else {
//                    ((Items) getAdapter().getItems()).remove(holder.getAdapterPosition() + 1);
//                    getAdapter().notifyItemRemoved(holder.getAdapterPosition() + 1);
//                    deparmentItem.isExpand = false;
//                }
//            }
//        });
    }
}
