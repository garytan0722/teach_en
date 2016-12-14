package com.genglun.teach_en.practice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.genglun.teach_en.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by garytan on 2015/12/5.
 */
public class practice extends AppCompatActivity {
    public List<practice_item> Items;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practice);
        RecyclerView rv = (RecyclerView)findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        initializeData();
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        RVAdapter adapter = new RVAdapter(Items,this);
        rv.setAdapter(adapter);
    }
    public void initializeData(){
        Items=new ArrayList<>();
        Items.add(new practice_item("Class1",4,R.drawable.class1));
        Items.add(new practice_item("Class2",3,R.drawable.class2));
        Items.add(new practice_item("Class3", 3,R.drawable.class3));
    }
}
