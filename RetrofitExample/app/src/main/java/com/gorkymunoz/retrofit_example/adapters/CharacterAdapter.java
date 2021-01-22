package com.gorkymunoz.retrofit_example.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.gorkymunoz.retrofit_example.R;
import com.gorkymunoz.retrofit_example.network.models.character.Character;

import java.util.List;

/**
 * Created by Gorky Muñoz on 21/1/2021.
 * <p>
 * gorkymunoz@hotmail.com
 */
public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterVH> {

    Context context;
    List<Character> characterList;

    public CharacterAdapter(Context context, List<Character> characterList) {
        this.context = context;
        this.characterList = characterList;
    }

    @NonNull
    @Override
    public CharacterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_character, parent, false);
        return new CharacterVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterVH holder, int position) {
        holder.bind(characterList.get(position), context);
    }

    @Override
    public int getItemCount() {
        return characterList.size();
    }

    static class CharacterVH extends RecyclerView.ViewHolder {

        ImageView characterImage;
        TextView name, status, species, totalEpisodes;

        void bind(Character character, Context context) {
            Glide
                    .with(context)
                    .load(character.getImage())
                    .into(characterImage);

            name.setText(character.getName());
            status.setText(character.getStatus());
            species.setText(character.getSpecies());
            Resources resources = context.getResources();
            int totalEpisodesValue = character.getEpisode().size();
            totalEpisodes.setText(resources.getQuantityString(R.plurals.total_episodes, totalEpisodesValue, totalEpisodesValue));

        }

        public CharacterVH(@NonNull View itemView) {
            super(itemView);
            characterImage = itemView.findViewById(R.id.iv_character_image);
            name = itemView.findViewById(R.id.tv_character_name);
            status = itemView.findViewById(R.id.tv_character_status);
            species = itemView.findViewById(R.id.tv_character_species);
            totalEpisodes = itemView.findViewById(R.id.tv_character_episodes);

        }
    }
}
