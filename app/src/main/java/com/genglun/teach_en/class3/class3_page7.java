package com.genglun.teach_en.class3;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.genglun.teach_en.R;
import com.genglun.teach_en.tab.BaseFragment;

/**
 * Created by garytan on 2015/10/17.
 */
public class class3_page7 extends BaseFragment implements View.OnClickListener {

    private static final String TAG="class3page7";
    private MediaPlayer mp;
    public static class3_page7 newInstance() {
        Log.d(TAG, "newInstance");
        class3_page7 f = new class3_page7();

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
        return inflater.inflate(R.layout.class3_page7, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "onViewCreated");
        TextView hot=(TextView) view.findViewById(R.id.cool);
        hot.setText("cool");

        FloatingActionButton voice = (FloatingActionButton) view.findViewById(R.id.voice);
        voice.setOnClickListener(this);

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
                resid=R.raw.cool;
                if (mp != null) {
                    mp.release();
                }
                // Create a new MediaPlayer to play this sound
                mp = MediaPlayer.create(getActivity(),resid);
                mp.start();


        }

    }

}
