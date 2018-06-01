package com.example.key.zuzhi.databinding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.example.key.zuzhi.data.Resource;

import java.util.List;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;


/**
 * Created by mertsimsek on 20/05/2017.
 */

public final class ListBindingAdapter {
    @BindingAdapter(value = "items")
    public static void setItems(RecyclerView recyclerView, Items items){
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if(adapter == null)
            return;

        if(items == null)
            return;

        if(adapter instanceof MultiTypeAdapter){
            ((MultiTypeAdapter)adapter).setItems(items);
            adapter.notifyDataSetChanged();
        }
    }
}
