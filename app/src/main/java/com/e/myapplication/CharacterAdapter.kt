package com.e.myapplication

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class CharacterAdapter:ListAdapter<CharacterClass,CharacterAdapter.ViewHolder>(DiffCallBack){
    lateinit var OnItemSelectedListener: (CharacterClass) -> Unit
    inner class ViewHolder(val view: View):RecyclerView.ViewHolder(view){
        val idchracter:TextView= view.findViewById(R.id.itemid)
        val namecharacter:TextView= view.findViewById(R.id.itemname)
        val alivecharacter:TextView= view.findViewById(R.id.itemstatus)
        fun onBind(character:CharacterClass){
            idchracter.text=character.ID
            namecharacter.text=character.name
            alivecharacter.text=character.status
            view.setOnClickListener {
                OnItemSelectedListener(character)
            }
        }


    }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val myview:View=LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return ViewHolder(myview)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val holderbind=getItem(position)
        holder.onBind(holderbind)
    }
    companion object DiffCallBack : DiffUtil.ItemCallback<CharacterClass>() {
        override fun areItemsTheSame(oldItem: CharacterClass, newItem: CharacterClass): Boolean {
            return oldItem.ID == newItem.ID
        }

        override fun areContentsTheSame(oldItem: CharacterClass, newItem: CharacterClass): Boolean {
            return oldItem == newItem
        }
    }
}