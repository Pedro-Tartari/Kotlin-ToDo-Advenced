package com.example.todonext.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todonext.model.Item
import com.example.todonext.databinding.AdapterRowBinding

class ItemListAdapter (var itens: List<Item>): RecyclerView.Adapter<ItemListAdapter.ToDoViewHolder>(){

    //AdapterRowBinding -> nome do XML, ele faz a busca dos itens posteriormete. É criado automaticamente
    inner class ToDoViewHolder(val binding: AdapterRowBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = AdapterRowBinding.inflate(layoutInflater, parent, false)
        return ToDoViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return  itens.size
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
       holder.binding.apply {
           tvItemName.text = itens[position].name
           cbIsCheck.isChecked = itens[position].isChecked
       }
    }

}