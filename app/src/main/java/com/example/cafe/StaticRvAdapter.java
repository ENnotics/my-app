package com.example.cafe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StaticRvAdapter extends  RecyclerView.Adapter<StaticRvAdapter.StaticRvviewHolder > {
    private ArrayList<StaticRvModel> items;
    int row_index = -1;


    public  StaticRvAdapter(ArrayList<StaticRvModel> items) {
        this.items  = items;
    }

    @NonNull
    @Override
    public StaticRvviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.static_rv_item,parent,false);
        StaticRvviewHolder staticRvviewHolder = new StaticRvviewHolder(view);
        return  staticRvviewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StaticRvviewHolder holder, final int position) {
        StaticRvModel currentItem = items.get(position);
        holder.imageView.setImageResource(currentItem.getImage());
        holder.textView.setText(currentItem.getText());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row_index = position;
                notifyDataSetChanged();

            }
        });
        if ( row_index == position){
            holder.linearLayout.setBackgroundResource(R.drawable.static_rv_bg);
        }
        else {
            holder.linearLayout.setBackgroundResource(R.drawable.static_rv_shape);
        }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class StaticRvviewHolder extends RecyclerView.ViewHolder{

TextView textView;
ImageView imageView;
LinearLayout linearLayout;

        public StaticRvviewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.text_pizza);
            imageView = itemView.findViewById(R.id.image_pizza);
            linearLayout = itemView.findViewById(R.id.linerLayour);
        }
    }
}
