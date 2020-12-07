package com.bdtheme.receipedagger.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bdtheme.receipedagger.R
import com.bdtheme.receipedagger.databinding.ListRowBinding
import com.bdtheme.receipedagger.model.ReceipeModel
import com.bdtheme.receipedagger.ui.DetailsActivity

class ReceipeAdapter(var context: Context) :
    RecyclerView.Adapter<ReceipeAdapter.ViewHolder>() {
    private var list: List<ReceipeModel> = emptyList<ReceipeModel>()

    class ViewHolder(
        val itemBinding: ListRowBinding
    ) :
        RecyclerView.ViewHolder(itemBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ListRowBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.list_row,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemBinding.list = list.get(position)

        holder.itemView.setOnClickListener {
            context.startActivity(
                Intent(context, DetailsActivity::class.java).putExtra(
                    "Recepe",
                    list.get(position)
                )
            )
        }
    }

    fun setAdapterList(list: List<ReceipeModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }
}