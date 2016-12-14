package com.genglun.teach_en.class1_practice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.genglun.teach_en.R;

/**
 * Created by garytan on 2015/10/18.
 */
public  class class1_practice_activity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class1_practice);
        Log.d("class1_practice", "onCreate");
        initTabFragment(savedInstanceState);

    }

    private void initTabFragment(Bundle savedInstanceState){
        if (savedInstanceState == null) {
            Log.d("class1_practice","savedInstanceState is  null");
            class1_practice_tab tabFragment = new class1_practice_tab();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.content_fragment, tabFragment)
                    .commit();
        }
    }
}
