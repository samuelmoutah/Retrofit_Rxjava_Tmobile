package com.rjt.retrofitrxjava.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rjt.retrofitrxjava.R
import com.rjt.retrofitrxjava.models.Users
import kotlinx.android.synthetic.main.category_row_adapter.view.*

class Adapter (var mContext: Context, var mList: ArrayList<Users>) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(mContext).inflate(R.layout.category_row_adapter, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var users = mList.get(position)

        holder.bindView(users)
    }

    fun setData(list: ArrayList<Users>) {
        mList = list
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(users: Users) {
            itemView.text_view_lat.text = users.address.geo.lat
            itemView.text_view_company_name.text = users.company.name
        }

    }
}