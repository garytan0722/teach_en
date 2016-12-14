package com.genglun.teach_en.setting;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.genglun.teach_en.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by garytan on 2015/12/5.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ScoreViewHolder>{
    public List<Score> scores;
    public static class ScoreViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView score;
        TextView time;
        ImageView image;

        ScoreViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            score = (TextView)itemView.findViewById(R.id.score);
            time = (TextView)itemView.findViewById(R.id.time);
            image = (ImageView)itemView.findViewById(R.id.image);
        }
    }
    RVAdapter(List<Score> scores){
        this.scores = scores;
    }

    @Override
    public ScoreViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.record_item, viewGroup, false);
        ScoreViewHolder pvh = new ScoreViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ScoreViewHolder holder, int i) {
        holder.score.setText("Score:"+scores.get(i).score);
        Date d = new Date(Long.valueOf(scores.get(i).time)*1000);
        SimpleDateFormat f = new SimpleDateFormat("MM月dd號 HH:mm");
        f.setTimeZone(TimeZone.getDefault());
        String convert_time = f.format(d);
        holder.time.setText("Time:"+convert_time);
        if(Double.valueOf(scores.get(i).score)<60) {
            holder.image.setBackgroundResource(R.drawable.warn_shape);
        } else {
            holder.image.setBackgroundResource(R.drawable.great_shape);
        }
    }



    @Override
    public int getItemCount() {
        return scores.size();
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }



}