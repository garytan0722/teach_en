package com.genglun.teach_en.class3_practice;

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
public class class3_practice_page6 extends BaseFragment implements View.OnClickListener {
    private static final String TAG="class3_practice_page6";
    private int id;
    private String ans,image;
    private TextView show;
    private EditText ans_text;
    private SharedPreferences share;
    public class3_practice_page6(String id, String ans, String image) {
        this.ans = ans;
        this.id = Integer.parseInt(id);
        this.image = image;
    }
    public static class3_practice_page6 newInstance(String id,String ans,String image) {
        Log.d(TAG, "newInstance");
        Log.d(TAG,"ID:::"+id);
        Log.d(TAG,"Ans:::"+ans);
        Log.d(TAG,"Image:::"+image);
        class3_practice_page6 f = new class3_practice_page6(id,ans,image);
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
        Log.d(TAG, "onCreateView");
        return inflater.inflate(R.layout.class3_practice_page6, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "onViewCreated");
        switch (id){
            case 1:
                ImageView image1=(ImageView)view.findViewById(R.id.image);
                TextView text=(TextView)view.findViewById(R.id.text);
                image1.setImageResource(R.drawable.sunny);
                text.setText("s");
                break;
            case 2:
                ImageView image2=(ImageView)view.findViewById(R.id.image);
                TextView text2=(TextView)view.findViewById(R.id.text);
                image2.setImageResource(R.drawable.rainy);
                text2.setText("r");
                break;
            case 3:
                ImageView image3=(ImageView)view.findViewById(R.id.image);
                TextView text3=(TextView)view.findViewById(R.id.text);
                image3.setImageResource(R.drawable.windy);
                text3.setText("w");
                break;
            case 4:
                ImageView image4=(ImageView)view.findViewById(R.id.image);
                TextView text4=(TextView)view.findViewById(R.id.text);
                image4.setImageResource(R.drawable.cloudy);
                text4.setText("c");
                break;
            case 5:
                ImageView image5=(ImageView)view.findViewById(R.id.image);
                TextView text5=(TextView)view.findViewById(R.id.text);
                image5.setImageResource(R.drawable.hot);
                text5.setText("h");
                break;
            case 6:
                ImageView image6=(ImageView)view.findViewById(R.id.image);
                TextView text6=(TextView)view.findViewById(R.id.text);
                image6.setImageResource(R.drawable.warm);
                text6.setText("w");
                break;
            case 7:
                ImageView image7=(ImageView)view.findViewById(R.id.image);
                TextView text7=(TextView)view.findViewById(R.id.text);
                image7.setImageResource(R.drawable.cool);
                text7.setText("c");
                break;
            case 8:
                ImageView image8=(ImageView)view.findViewById(R.id.image);
                TextView text8=(TextView)view.findViewById(R.id.text);
                image8.setImageResource(R.drawable.cold);
                text8.setText("c");
                break;


        }
        BootstrapButton submit=(BootstrapButton)view.findViewById(R.id.submit);
        show=(TextView)view.findViewById(R.id.show);
        ans_text=(EditText)view.findViewById(R.id.editText);

        submit.setOnClickListener(this);
        share=getActivity().getSharedPreferences("class3_answer", Context.MODE_PRIVATE);
        String show_ans=share.getString("q6","No Answer");
        show.setText("Your Answer:" + show_ans);


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated");
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
    }



    @Override
    public void onDestroyView() {
        Log.d(TAG, "onDestroyView");
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
                            show.setText("Your Answer:" +"s"+submit_ans);
                            break;
                        case 2:
                            show.setText("Your Answer:" + "r"+submit_ans);
                            break;
                        case 3:
                            show.setText("Your Answer:" +"w"+submit_ans);
                            break;
                        case 4:
                            show.setText("Your Answer:" +"c"+submit_ans);
                            break;
                        case 5:
                            show.setText("Your Answer:" +"h"+submit_ans);
                            break;
                        case 6:
                            show.setText("Your Answer:" +"w"+submit_ans);
                            break;
                        case 7:
                            show.setText("Your Answer:" +"c"+submit_ans);
                            break;
                        case 8:
                            show.setText("Your Answer:" +"c"+submit_ans);
                            break;
                    }
                    SharedPreferences.Editor editor=getActivity().getSharedPreferences("class3_answer", Context.MODE_PRIVATE).edit();
                    editor.putString("q6",submit_ans);
                    editor.putInt("q6id",id);
                    editor.commit();
                }catch (Exception e){
                    show.setText("No Answer");
                }
                break;
        }

    }



}
