package me.anky.retrofityoutube.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import me.anky.retrofityoutube.R;

/**
 * Created by Anky An on 12/06/2017.
 * anky25@gmail.com
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder
    implements View.OnClickListener{

    public TextView name, hobby;

    public RecyclerViewHolder(View itemView) {
        super(itemView);

        itemView.setOnClickListener(this);

        name = (TextView)itemView.findViewById(R.id.name);
        hobby = (TextView)itemView.findViewById(R.id.hobby);

    }

    @Override
    public void onClick(View v) {

    }
}
