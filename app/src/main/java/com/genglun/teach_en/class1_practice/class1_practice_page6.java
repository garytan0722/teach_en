package com.genglun.teach_en.class1_practice;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.genglun.teach_en.MainActivity;
import com.genglun.teach_en.R;
import com.genglun.teach_en.sql.db_helper;
import com.genglun.teach_en.tab.BaseFragment;

/**
 * Created by garytan on 2015/11/3.
 */
public class class1_practice_page6 extends BaseFragment implements View.OnClickListener {
    private static final String TAG="class1_practice_page6";
    private int id;
    private String ans,image;
    private TextView show;
    private EditText ans_text;
    private SharedPreferences share;
    private int q1id,q2id,q3id,q4id,q5id,q6id;
    private  int score,point;
    public class1_practice_page6(String id, String ans, String image) {
        this.ans = ans;
        this.id = Integer.parseInt(id);
        this.image = image;
    }
    public static class1_practice_page6 newInstance(String id,String ans,String image) {
        Log.d(TAG, "newInstance");
        Log.d(TAG,"ID:::"+id);
        Log.d(TAG,"Ans:::"+ans);
        Log.d(TAG,"Image:::"+image);
        class1_practice_page6 f = new class1_practice_page6(id,ans,image);
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
        return inflater.inflate(R.layout.class1_practice_page6, container, false);
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
        String show_ans=share.getString("q6","No Answer");
        show.setText("Your Answer:" + show_ans);
            FloatingActionButton voice = (FloatingActionButton) view.findViewById(R.id.send);
            voice.setOnClickListener(this);

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
                    editor.putString("q6",submit_ans);
                    editor.putInt("q6id",id);
                    editor.commit();
                }catch (Exception e){
                    show.setText("No Answer");
                }
                break;
            case R.id.send:
                share=getActivity().getSharedPreferences("class1_answer", Context.MODE_PRIVATE);
                getq();
                score=check_ans();
                if(score==6){
                    score=100;
                }else{
                    score=score*16;
                }
                Log.d("calss1_practice_page6", "Score:::" + score);
                db_helper db=new db_helper(getActivity(),"question_db",null,1);
                long time=System.currentTimeMillis() / 1000L;
                db.record_add("1",String.valueOf(time),String.valueOf(score) );
                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                dialog.setTitle("Score");
                dialog.setMessage("Your Score:" + String.valueOf(score));
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent=new Intent(getActivity(), MainActivity.class);
                                startActivity(intent);
                                getActivity().finish();
                            }
                        }
                );
                dialog.create();
                dialog.show();
                SharedPreferences.Editor editor = share.edit();
                editor.clear();
                editor.commit();
                break;
        }

    }
    private void getq(){
        q1id=share.getInt("q1id", 0);
        q2id=share.getInt("q2id", 0);
        q3id=share.getInt("q3id", 0);
        q4id=share.getInt("q4id", 0);
        q5id=share.getInt("q5id",0);
        q6id=share.getInt("q6id",0);
    }
    private int check_ans(){

        String ans1=share.getString("q1",null);
        String ans2=share.getString("q2",null);
        String ans3=share.getString("q3",null);
        String ans4=share.getString("q4",null);
        String ans5=share.getString("q5",null);
        String ans6=share.getString("q6",null);
        switch (q1id){
            case 1:
                if(ans1.equals("ating breakfast")){
                    point=point+1;
                }
                break;
            case 2:
                if(ans1.equals("ating lunch")){
                    point=point+1;
                }
                break;
            case 3:
                if(ans1.equals("ating dinner")){
                    point=point+1;
                }
                break;
            case 4:
                if(ans1.equals("tudying")){
                    point=point+1;

                }
                break;
            case 5:
                if(ans1.equals("atching TV")){
                    point=point+1;

                }
                break;
            case 6:
                if(ans1.equals("leep")){
                    point=point+1;

                }
                break;

        }
        switch (q2id){
            case 1:
                if(ans2.equals("ating breakfast")){
                    point=point+1;

                }
                break;
            case 2:
                if(ans2.equals("ating lunch")){
                    point=point+1;

                }
                break;
            case 3:
                if(ans2.equals("ating dinner")){
                    point=point+1;

                }
                break;
            case 4:
                if(ans2.equals("tudying")){
                    point=point+1;

                }
                break;
            case 5:
                if(ans2.equals("atching TV")){
                    point=point+1;

                }
                break;
            case 6:
                if(ans2.equals("leep")){
                    point=point+1;

                }
                break;

        }
        switch (q3id){
            case 1:
                if(ans3.equals("ating breakfast")){
                    point=point+1;

                }
                break;
            case 2:
                if(ans3.equals("ating lunch")){
                    point=point+1;

                }
                break;
            case 3:
                if(ans3.equals("ating dinner")){
                    point=point+1;

                }
                break;
            case 4:
                if(ans3.equals("tudying")){
                    point=point+1;

                }
                break;
            case 5:
                if(ans3.equals("atching TV")){
                    point=point+1;

                }
                break;
            case 6:
                if(ans3.equals("leep")){
                    point=point+1;

                }
                break;

        }
        switch (q4id){
            case 1:
                if(ans4.equals("ating breakfast")){
                    point=point+1;

                }
                break;
            case 2:
                if(ans4.equals("ating lunch")){
                    point=point+1;

                }
                break;
            case 3:
                if(ans4.equals("ating dinner")){
                    point=point+1;

                }
                break;
            case 4:
                if(ans4.equals("tudying")){
                    point=point+1;

                }
                break;
            case 5:
                if(ans4.equals("atching TV")){
                    point=point+1;

                }
                break;
            case 6:
                if(ans4.equals("leep")){
                    point=point+1;

                }
                break;

        }
        switch (q5id){
            case 1:
                if(ans5.equals("ating breakfast")){
                    point=point+1;

                }
                break;
            case 2:
                if(ans5.equals("ating lunch")){
                    point=point+1;

                }
                break;
            case 3:
                if(ans5.equals("ating dinner")){
                    point=point+1;

                }
                break;
            case 4:
                if(ans5.equals("tudying")){
                    point=point+1;

                }
                break;
            case 5:
                if(ans5.equals("atching TV")){
                    point=point+1;

                }
                break;
            case 6:
                if(ans5.equals("leep")){
                    point=point+1;

                }
                break;

        }
        switch (q6id){
            case 1:
                if(ans6.equals("ating breakfast")){
                    point=point+1;
                }
                break;
            case 2:
                if(ans6.equals("ating lunch")){
                    point=point+1;
                }
                break;
            case 3:
                if(ans6.equals("ating dinner")){
                    point=point+1;
                }
                break;
            case 4:
                if(ans6.equals("tudying")){
                    point=point+1;

                }
                break;
            case 5:
                if(ans6.equals("atching TV")){
                    point=point+1;

                }
                break;
            case 6:
                if(ans6.equals("leep")){
                    point=point+1;

                }
                break;

        }
        Log.d("calss1_practice_page6","Point::"+point);
        return point;
    }


}
