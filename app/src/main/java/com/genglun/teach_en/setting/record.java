package com.genglun.teach_en.setting;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.genglun.teach_en.R;
import com.genglun.teach_en.sql.db_helper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by garytan on 2015/11/22.
 */
public class record extends Activity {
    public final String TAG="record";
    public String time,score;
    public List<Score> Scores;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.record);
        RecyclerView rv = (RecyclerView)findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        initializeData();
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        RVAdapter adapter = new RVAdapter(Scores);
        rv.setAdapter(adapter);
    }

    private void initializeData(){
        Scores = new ArrayList<>();
        db_helper db = new db_helper(getApplicationContext(), "question_db", null, 1);
        Cursor c = db.gettotalrecord();
        for (int i = 0; i < c.getCount(); i++) {
            c.moveToPosition(i);
            c.getString(0);
            time=c.getString(1);
            score=c.getString(2);
            Log.d(TAG,"Score:"+score);
            Log.d(TAG,"Time:"+time);
            Scores.add(new Score(score, time));
        }
        c.close();
        SQLiteDatabase ret_db =db_helper.getdatabase();
        ret_db.close();
    }

}






