package com.genglun.teach_en.class2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.genglun.teach_en.R;
import com.genglun.teach_en.class1.class1_tab;

/**
 * Created by garytan on 15/10/3.
 */
public class class2_main_activity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class2_main_activity);
        initTabFragment(savedInstanceState);
        setTitle("Class2 Word");
    }
    private void initTabFragment(Bundle savedInstanceState){
        if (savedInstanceState == null) {
            class2_tab tabFragment = new class2_tab();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.content_fragment, tabFragment)
                    .commit();
        }
    }


}

