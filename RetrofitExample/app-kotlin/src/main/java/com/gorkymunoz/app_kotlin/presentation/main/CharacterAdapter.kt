package com.gorkymunoz.app_kotlin.presentation.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gorkymunoz.app_kotlin.databinding.ListItemCharacterBinding
import com.gorkymunoz.app_kotlin.network.model.character.Character


/**
 * Created by Gorky Muñoz on 8/8/2021.
 *
 * Adapter for character list
 */
class CharacterAdapter : ListAdapter<Character, CharacterViewHolder>(CharacterDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CharacterViewHolder(
            ListItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class CharacterViewHolder(private val binding: ListItemCharacterBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Character) {
        binding.apply {
            character = item
            executePendingBindings()
        }
    }

}

private class CharacterDiffCallback : DiffUtil.ItemCallback<Character>() {

    override fun areItemsTheSame(oldItem: Character, newItem: Character) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Character, newItem: Character) =
        oldItem == newItem

}
