package com.genglun.teach_en.class2_practice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.genglun.teach_en.R;

/**
 * Created by garytan on 2015/10/18.
 */
public class class2_practice_activity extends AppCompatActivity{
    String t1,t2,t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class2_practice);
        Log.d("class2_practice", "onCreate");
        initTabFragment(savedInstanceState);

    }

    private void initTabFragment(Bundle savedInstanceState){
        if (savedInstanceState == null) {
            class2_practice_tab tabFragment = new class2_practice_tab();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.content_fragment, tabFragment)
                    .commit();
        }
    }
}
