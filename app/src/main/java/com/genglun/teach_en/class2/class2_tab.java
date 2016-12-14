package com.genglun.teach_en.class2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.genglun.teach_en.R;
import com.genglun.teach_en.adapter.TabFragmentPagerAdapter;
import com.genglun.teach_en.tab.BaseFragment;

import java.util.LinkedList;

/**
 * Created by garytan on 15/10/3.
 */
public class class2_tab extends Fragment {

    //private SlidingTabLayout tabs;
    private ViewPager pager;
    private FragmentPagerAdapter adapter;

    public static Fragment newInstance(){
        class2_tab f = new class2_tab();
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.class2_tab, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        //adapter
        final LinkedList<BaseFragment> fragments = getFragments();
        adapter = new TabFragmentPagerAdapter(getFragmentManager(), fragments);
        //pager
        pager = (ViewPager) view.findViewById(R.id.pager);
        pager.setAdapter(adapter);
        //tabs
//        tabs = (SlidingTabLayout) view.findViewById(R.id.tabs);
//        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
//
//            @Override
//            public int getIndicatorColor(int position) {
//                return fragments.get(position).getIndicatorColor();
//            }
//
//            @Override
//            public int getDividerColor(int position) {
//                return fragments.get(position).getDividerColor();
//            }
//        });
//        tabs.setBackgroundResource(R.color.white);
//        tabs.setCustomTabView(R.layout.tab_title, R.id.txtTabTitle, 0);
//        tabs.setViewPager(pager);
    }


    private LinkedList<BaseFragment> getFragments(){
        LinkedList<BaseFragment> fragments = new LinkedList<BaseFragment>();

        fragments.add(class2_page1.newInstance());
        fragments.add(class2_page2.newInstance());
        fragments.add(class2_page3.newInstance());
        fragments.add(class2_page4.newInstance());
        fragments.add(class2_page5.newInstance());
        return fragments;
    }

}

