package com.bdtheme.receipedagger.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bdtheme.receipedagger.R
import com.bdtheme.receipedagger.databinding.ListRowBinding
import com.bdtheme.receipedagger.model.ReceipeModel
import com.bdtheme.receipedagger.ui.ItemSelectedListener

class ReceipeAdapter(var context: Context,var onItemSelectedListener: ItemSelectedListener) :
    RecyclerView.Adapter<ReceipeAdapter.ViewHolder>() {
    private var list: List<ReceipeModel> = emptyList<ReceipeModel>()
    lateinit var onItemSelected: ItemSelectedListener
    init {
        this.onItemSelected = onItemSelectedListener
    }

    class ViewHolder( val itemBinding: ListRowBinding, onItemSelectedListener: ItemSelectedListener) :
        RecyclerView.ViewHolder(itemBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ListRowBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.list_row,
            parent,
            false
        )
        return ViewHolder(binding, onItemSelectedListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemBinding.list = list.get(position)

        holder.itemView.setOnClickListener {
            Toast.makeText(context, "clicked", Toast.LENGTH_LONG).show()
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