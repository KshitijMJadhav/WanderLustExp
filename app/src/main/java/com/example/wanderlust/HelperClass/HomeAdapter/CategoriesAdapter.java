package com.example.wanderlust.HelperClass.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wanderlust.R;

import java.util.ArrayList;

public class CategoriesAdapter extends RecyclerView.Adapter <CategoriesAdapter.CategoriesViewHolder>{

    ArrayList<CategoriesHelperClass> categoriesLocations;

    public CategoriesAdapter(ArrayList<CategoriesHelperClass> categoriesLocaions) {
        this.categoriesLocations = categoriesLocaions;
    }

    @NonNull
    @Override
    public CategoriesAdapter.CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_card_design, parent, false);
        CategoriesAdapter.CategoriesViewHolder categorieViewHolder = new CategoriesAdapter.CategoriesViewHolder(view);
        return categorieViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesAdapter.CategoriesViewHolder holder, int position) {

        CategoriesHelperClass categoriesHelperClass = categoriesLocations.get(position);

        holder.image.setImageResource(categoriesHelperClass.getImage());
        holder.title.setText(categoriesHelperClass.getTitle());


    }

    @Override
    public int getItemCount() {
        return categoriesLocations.size();
    }

    public static class CategoriesViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title;

        public CategoriesViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.category_image);
            title = itemView.findViewById(R.id.category_title);

        }
    }

}
