package com.genglun.teach_en.practice;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.genglun.teach_en.R;
import com.genglun.teach_en.class1_practice.class1_practice_activity;
import com.genglun.teach_en.class2_practice.class2_practice_activity;
import com.genglun.teach_en.class3_practice.class3_practice_activity;

import java.util.List;

/**
 * Created by garytan on 2015/12/5.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ScoreViewHolder> implements View.OnClickListener{
    public final String TAG="RVAdapter";
    public List<practice_item> Items;
    public Context context;
    @Override
    public void onClick(View v) {
        int tag = (Integer) v.getTag();
       switch (tag){
           case 0:
               Intent class1_practice_intent=new Intent(context,class1_practice_activity.class);
               context.startActivity(class1_practice_intent);
               break;
           case 1:
               Intent class2_practice_intent=new Intent(context,class2_practice_activity.class);
               context.startActivity(class2_practice_intent);
               break;
           case 2:
               Intent class3_practice_intent=new Intent(context,class3_practice_activity.class);
               context.startActivity(class3_practice_intent);
               break;
       }

    }

    public static class ScoreViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView name;
        LinearLayout star;
        ImageView image;
        BootstrapButton start;
        ScoreViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            name = (TextView)itemView.findViewById(R.id.name);
            star = (LinearLayout) itemView.findViewById(R.id.star);
            image = (ImageView)itemView.findViewById(R.id.image);
            start=(BootstrapButton)itemView.findViewById(R.id.start);
        }
    }
    RVAdapter(List<practice_item> Items,Context context){

        this.Items = Items;
        this.context=context;
    }

    @Override
    public ScoreViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.practice_item, viewGroup, false);
        ScoreViewHolder pvh = new ScoreViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ScoreViewHolder holder, int i) {
        holder.name.setText(Items.get(i).name);
        holder.image.setImageResource(Items.get(i).image);
        for(int s=0;s<Items.get(i).hard;s++){
            ImageView image = new ImageView(context);
            image.setImageResource(R.drawable.star);
            holder.star.addView(image);
        }
        holder.start.setTag(i);
        holder.start.setOnClickListener(this);
    }



    @Override
    public int getItemCount() {
        return Items.size();
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }



}