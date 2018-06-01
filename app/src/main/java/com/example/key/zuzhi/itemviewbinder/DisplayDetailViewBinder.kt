package com.example.key.zuzhi.itemviewbinder

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.blankj.utilcode.util.ConvertUtils
import com.example.key.zuzhi.R
import com.example.key.zuzhi.event.LeaderMessageEvent
import com.example.key.zuzhi.item.DisplayDetailItem
import me.drakeet.multitype.ItemViewBinder
import org.greenrobot.eventbus.EventBus

class DisplayDetailViewBinder(val ctx: Context) : ItemViewBinder<DisplayDetailItem, DisplayDetailViewBinder.DisplayDetailItemViewHolder>() {
    override fun onBindViewHolder(holder: DisplayDetailItemViewHolder, item: DisplayDetailItem) {
        val group = holder.group
        group.removeAllViews()
        if (group.childCount == 0)
            for (i in 0 until item.titles.size) {

                val title = TextView(ctx).apply {
                    text = item.titles[i]
                    textSize = 18f
                }

                val content = TextView(ctx).apply {
                    text = item.contents[i]
                    textSize = 14f
                }

                Log.e("ViewBinder", "titles = " + title.text);
                Log.e("ViewBinder", "titles = " + content.text);

                group.addView(title)
                group.addView(content)

                val lpt = title.layoutParams as LinearLayout.LayoutParams
                lpt.leftMargin = ConvertUtils.dp2px(16f)
                lpt.topMargin = ConvertUtils.dp2px(2f)
                title.layoutParams = lpt

                val lpc = content.layoutParams as LinearLayout.LayoutParams
                lpc.leftMargin = ConvertUtils.dp2px(24f)
                lpc.topMargin = ConvertUtils.dp2px(2f)
                content.layoutParams = lpc

            }

        // 事件通知
        group.setOnClickListener(View.OnClickListener {
            EventBus.getDefault().post(LeaderMessageEvent(2));
        })
    }

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): DisplayDetailItemViewHolder = DisplayDetailItemViewHolder(inflater.inflate(R.layout.item_display_detail, parent, false))

    class DisplayDetailItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val group : LinearLayout = itemView.findViewById(R.id.detail_group)
    }
}