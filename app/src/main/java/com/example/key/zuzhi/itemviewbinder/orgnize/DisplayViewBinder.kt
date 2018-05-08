package com.example.key.zuzhi.itemviewbinder.orgnize

import android.graphics.BitmapFactory
import android.support.v7.widget.RecyclerView
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.key.zuzhi.R
import com.example.key.zuzhi.item.orgnize.DisplayDetailItem
import com.example.key.zuzhi.item.orgnize.DisplayItem
import me.drakeet.multitype.ItemViewBinder
import me.drakeet.multitype.Items

class DisplayViewBinder() : ItemViewBinder<DisplayItem, DisplayViewBinder.DisplayItemViewHolder>() {
    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): DisplayItemViewHolder = DisplayItemViewHolder(inflater.inflate(R.layout.item_display, parent, false))

    override fun onBindViewHolder(holder: DisplayItemViewHolder, item: DisplayItem) {
        holder.name.text = item.userName
        holder.jobName.text = item.userJobName
        holder.avatar.setImageResource(R.drawable.timg)

        holder.container.setOnClickListener {

            if (((adapter.items as Items).get(holder.adapterPosition) is DisplayItem)) {
                val displayItem = (adapter.items as Items).get(holder.adapterPosition) as DisplayItem
                if (!displayItem.isExpand) {
                    (adapter.items as Items).add(holder.adapterPosition + 1,
                            DisplayDetailItem(arrayOf("职责分工", "主管部门"), arrayOf("1.  2.  3.  ", "1.  2.  3.  ")))
                    adapter.notifyItemInserted(holder.adapterPosition + 1)
                    displayItem.isExpand = true
                } else {
                    adapter.items.removeAt(holder.adapterPosition + 1)
                    adapter.notifyItemRemoved(holder.adapterPosition + 1)
                    displayItem.isExpand = false
                }

            }
        }

    }


    class DisplayItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val avatar = itemView.findViewById<ImageView>(R.id.display_avatar)
        val name = itemView.findViewById<TextView>(R.id.display_name)
        val jobName = itemView.findViewById<TextView>(R.id.display_job)
        val container = itemView.findViewById<ViewGroup>(R.id.display_container)
    }
}