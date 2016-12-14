package com.genglun.teach_en.class3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.genglun.teach_en.R;

/**
 * Created by garytan on 15/10/3.
 */
public class class3_main_activity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class3_main_activity);
        initTabFragment(savedInstanceState);
        setTitle("Class3 Word");
    }
    private void initTabFragment(Bundle savedInstanceState){
        if (savedInstanceState == null) {
            class3_tab tabFragment = new class3_tab();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.content_fragment, tabFragment)
                    .commit();
        }
    }


}

