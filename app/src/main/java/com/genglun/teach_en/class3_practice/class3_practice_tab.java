package com.genglun.teach_en.class3_practice;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.genglun.teach_en.R;
import com.genglun.teach_en.adapter.TabFragmentPagerAdapter;
import com.genglun.teach_en.sql.db_helper;
import com.genglun.teach_en.tab.BaseFragment;

import java.util.LinkedList;

/**
 * Created by garytan on 2015/11/3.
 */
public class class3_practice_tab extends Fragment{
    private ViewPager pager;
    private FragmentPagerAdapter adapter;
    private String t1,t2,t3;
    public static Fragment newInstance(){
        Log.d("class3_practice_tab", "newInstance");
        class3_practice_tab f = new class3_practice_tab();
        return f;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("class3_practice_tab", "onCreateView");
        return inflater.inflate(R.layout.class3_practice_tab, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        //adapter
        Log.d("class1_practice_tab","onViewCreated");
        final LinkedList<BaseFragment> fragments = getFragments();
        adapter = new TabFragmentPagerAdapter(getFragmentManager(), fragments);
        //pager
        pager = (ViewPager) view.findViewById(R.id.pager);
        pager.setAdapter(adapter);

    }


    private LinkedList<BaseFragment> getFragments(){
        LinkedList<BaseFragment> fragments = new LinkedList<BaseFragment>();
        db_helper db=new db_helper(getActivity().getApplicationContext(),"question_db",null,1);
        Cursor c=db.class3_randomget();
        if(c==null){
            Log.d("class3_practice_tab", "Cursor is null");
        }else {
            int id=0;
            Log.d("class3_practice_tab", "Cursor Count:"+c.getCount());

            for (int i=0;i<c.getCount();i++) {
                c.moveToPosition(i);
                t1 = c.getString(0);
                t2 = c.getString(1);
                t3 = c.getString(2);
                Log.d("class3_practice_tab","T1::"+t1);
                Log.d("class3_practice_tab", "T2::" + t2);
                Log.d("class3_practice_tab", "ID::" + id);
                Log.d("class3_practice_tab","Psoition::"+c.getPosition());
                switch(id){
                    case 0:
                        Log.d("class3_practice_tab","Add0");
                        fragments.add(class3_practice_page1.newInstance(t1, t2, t3));
                        break;
                    case 1:
                        Log.d("class3_practice_tab","Add1");
                        fragments.add(class3_practice_page2.newInstance(t1, t2, t3));
                        break;
                    case 2:
                        Log.d("class3_practice_tab","Add2");
                        fragments.add(class3_practice_page3.newInstance(t1, t2, t3));
                        break;
                    case 3:
                        Log.d("class3_practice_tab","Add3");
                        fragments.add(class3_practice_page4.newInstance(t1, t2, t3));
                        break;
                    case 4:
                        Log.d("class3_practice_tab","Add4");
                        fragments.add(class3_practice_page5.newInstance(t1, t2, t3));
                        break;
                    case 5:
                        Log.d("class3_practice_tab","Add5");
                        fragments.add(class3_practice_page6.newInstance(t1, t2, t3));
                        break;
                    case 6:
                          Log.d("class3_practice_tab","Add6");
                       fragments.add(class3_practice_page7.newInstance(t1, t2, t3));
                       break;
                    case 7:
                        Log.d("class3_practice_tab","Add7");
                        fragments.add(class3_practice_page8.newInstance(t1, t2, t3));
                        break;
                }
                ++id;
            }

            c.close();
            SQLiteDatabase ret_db=db_helper.getdatabase();
            ret_db.close();
        }
        return fragments;
    }


}
