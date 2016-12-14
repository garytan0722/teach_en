package com.genglun.teach_en.class1_practice;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.genglun.teach_en.R;
import com.genglun.teach_en.tab.BaseFragment;

/**
 * Created by garytan on 2015/11/3.
 */
public class class1_practice_page5 extends BaseFragment implements View.OnClickListener {
    private static final String TAG="class1_practice_page5";
    private int id;
    private String ans,image;
    private TextView show;
    private EditText ans_text;
    private SharedPreferences share;
    public class1_practice_page5(String id, String ans, String image) {
        this.ans = ans;
        this.id = Integer.parseInt(id);
        this.image = image;
    }
    public static class1_practice_page5 newInstance(String id,String ans,String image) {
        Log.d(TAG, "newInstance");
        Log.d(TAG,"ID:::"+id);
        Log.d(TAG,"Ans:::"+ans);
        Log.d(TAG,"Image:::"+image);
        class1_practice_page5 f = new class1_practice_page5(id,ans,image);
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
        return inflater.inflate(R.layout.class1_practice_page5, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "onViewCreated");
        switch (id){
            case 1:
                ImageView image1=(ImageView)view.findViewById(R.id.image);
                TextView text=(TextView)view.findViewById(R.id.text);
                image1.setImageResource(R.drawable.breakfast);
                text.setText("e");
                break;
            case 2:
                ImageView image2=(ImageView)view.findViewById(R.id.image);
                TextView text2=(TextView)view.findViewById(R.id.text);
                image2.setImageResource(R.drawable.lunch);
                text2.setText("e");
                break;
            case 3:
                ImageView image3=(ImageView)view.findViewById(R.id.image);
                TextView text3=(TextView)view.findViewById(R.id.text);
                image3.setImageResource(R.drawable.dinner);
                text3.setText("e");
                break;
            case 4:
                ImageView image4=(ImageView)view.findViewById(R.id.image);
                TextView text4=(TextView)view.findViewById(R.id.text);
                image4.setImageResource(R.drawable.study);
                text4.setText("s");
                break;
            case 5:
                ImageView image5=(ImageView)view.findViewById(R.id.image);
                TextView text5=(TextView)view.findViewById(R.id.text);
                image5.setImageResource(R.drawable.tv);
                text5.setText("w");
                break;
            case 6:
                ImageView image6=(ImageView)view.findViewById(R.id.image);
                TextView text6=(TextView)view.findViewById(R.id.text);
                image6.setImageResource(R.drawable.sleep);
                text6.setText("s");
                break;
        }
        BootstrapButton submit=(BootstrapButton)view.findViewById(R.id.submit);
        show=(TextView)view.findViewById(R.id.show);
        ans_text=(EditText)view.findViewById(R.id.editText);

        submit.setOnClickListener(this);
        share=getActivity().getSharedPreferences("class1_answer", Context.MODE_PRIVATE);
        String show_ans=share.getString("q5","No Answer");
        show.setText("Your Answer:" + show_ans);
//
//            FloatingActionButton voice = (FloatingActionButton) view.findViewById(R.id.voice);
//            voice.setOnClickListener(this);
//            FloatingActionButton voice_ing = (FloatingActionButton) view.findViewById(R.id.voice_ing);
//            voice_ing.setOnClickListener(this);
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
        super.onDestroyView();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.submit:
                try {
                    String submit_ans = ans_text.getText().toString();
                    ans_text.setText("");
                    switch (id){
                        case 1:
                            show.setText("Your Answer:" +"e"+submit_ans);
                            break;
                        case 2:
                            show.setText("Your Answer:" + "e"+submit_ans);
                            break;
                        case 3:
                            show.setText("Your Answer:" +"e"+submit_ans);
                            break;
                        case 4:
                            show.setText("Your Answer:" +"s"+submit_ans);
                            break;
                        case 5:
                            show.setText("Your Answer:" +"w"+submit_ans);
                            break;
                        case 6:
                            show.setText("Your Answer:" +"s"+submit_ans);
                            break;

                    }
                    SharedPreferences.Editor editor=getActivity().getSharedPreferences("class1_answer", Context.MODE_PRIVATE).edit();
                    editor.putString("q5",submit_ans);
                    editor.putInt("q5id",id);
                    editor.commit();
                }catch (Exception e){
                    show.setText("No Answer");
                }
                break;
        }

    }
}