package com.genglun.teach_en.class2;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.genglun.teach_en.R;
import com.genglun.teach_en.tab.BaseFragment;

/**
 * Created by garytan on 15/10/3.
 */
public class class2_page2 extends BaseFragment implements View.OnClickListener {

    private static final String TAG="class2_page2";
    private MediaPlayer mp;
    public static class2_page2 newInstance() {
        Log.d(TAG, "newInstance");
        class2_page2 f = new class2_page2();

        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate");

        //get data
        //title = getArguments().getString(DATA_NAME);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG,"onCreateView");
        return inflater.inflate(R.layout.class2_page2, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "onViewCreated");
        TextView homework=(TextView) view.findViewById(R.id.homework);
        Spannable word = new SpannableString("Do");
        word.setSpan(new ForegroundColorSpan(Color.BLACK), 0, word.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        homework.setText(word);
        Spannable wordTwo = new SpannableString("ing");
        wordTwo.setSpan(new ForegroundColorSpan(Color.RED), 0, wordTwo.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        homework.append(wordTwo);

        FloatingActionButton voice = (FloatingActionButton) view.findViewById(R.id.voice);
        voice.setOnClickListener(this);
        FloatingActionButton voice_ing = (FloatingActionButton) view.findViewById(R.id.voice_ing);
        voice_ing.setOnClickListener(this);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG,"onActivityCreated");
    }

    @Override
    public void onDestroy() {
        Log.d(TAG,"onDestroy");
        super.onDestroy();
    }



    @Override
    public void onDestroyView() {
        Log.d(TAG,"onDestroyView");
        if(null!=mp){
            mp.release();
        }
        super.onDestroyView();
    }

    @Override
    public void onClick(View view) {
        int resid=0;
        switch (view.getId()){
            case R.id.voice:
                resid=R.raw.homework;
                if (mp != null) {
                    mp.release();
                }
                // Create a new MediaPlayer to play this sound
                mp = MediaPlayer.create(getActivity(),resid);
                mp.start();
                break;
            case R.id.voice_ing:
                resid=R.raw.homework_ing;
                if (mp != null) {
                    mp.release();
                }
                // Create a new MediaPlayer to play this sound
                mp = MediaPlayer.create(getActivity(),resid);
                mp.start();
                break;

        }

    }
}