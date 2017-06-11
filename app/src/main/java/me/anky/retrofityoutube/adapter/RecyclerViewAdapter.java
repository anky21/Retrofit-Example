package me.anky.retrofityoutube.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import me.anky.retrofityoutube.R;
import me.anky.retrofityoutube.model.Student;
import me.anky.retrofityoutube.viewholder.RecyclerViewHolder;

/**
 * Created by Anky An on 12/06/2017.
 * anky25@gmail.com
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private List<Student> itemList;

    public RecyclerViewAdapter(List<Student> itemList){
        this.itemList = itemList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row, null);

        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.name.setText(itemList.get(position).getName());
        holder.hobby.setText(itemList.get(position).getHobby());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}
