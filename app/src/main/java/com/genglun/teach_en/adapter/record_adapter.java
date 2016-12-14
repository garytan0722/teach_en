package com.genglun.teach_en.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.genglun.teach_en.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by garytan on 2015/11/22.
 */
    public class record_adapter  extends BaseAdapter{
    public Context context;
    List<String> time_list ,score_list;



    public record_adapter(Context context, List<String>time_list,List<String>score_list) {
        // TODO Auto-generated constructor stub
        this.time_list=time_list;
        this.score_list=score_list;
        this.context=context;

    }

    @Override
    public int getCount() {
        return time_list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class Holder
    {
        TextView score,time;
        ImageView img;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater  inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Holder holder=new Holder();
        View rootview = inflater.inflate(R.layout.record_item, parent, false);
        holder.score=(TextView)rootview.findViewById(R.id.score);
        holder.time=(TextView)rootview.findViewById(R.id.time);
        holder.img = (ImageView) rootview.findViewById(R.id.icon);
            String score=score_list.get(position).toString();
            Log.d("record_adapter","Score:"+score);
            holder.score.setText("Score:"+score);
            String time=time_list.get(position).toString();
            Date d = new Date(Long.valueOf(time)*1000);
            SimpleDateFormat f = new SimpleDateFormat("MM月dd號 HH:mm");
            f.setTimeZone(TimeZone.getDefault());
            String convert_time = f.format(d);
            holder.time.setText("Time:"+convert_time);
            // Change the icon
           if(Double.valueOf(score)<60) {
               holder.img.setBackgroundResource(R.drawable.warn_shape);
            } else {
               holder.img.setBackgroundResource(R.drawable.great_shape);
            }

        return rootview;
    }
}
