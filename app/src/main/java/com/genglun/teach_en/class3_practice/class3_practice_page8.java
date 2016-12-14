package com.genglun.teach_en.class3_practice;

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
public class class3_practice_page8 extends BaseFragment implements View.OnClickListener {
    private static final String TAG="class3_practice_page7";
    private int id;
    private String ans,image;
    private TextView show;
    private EditText ans_text;
    private SharedPreferences share;
    private int q1id,q2id,q3id,q4id,q5id,q6id,q7id,q8id;
    private  int point;
    private double score;
    public class3_practice_page8(String id, String ans, String image) {
        this.ans = ans;
        this.id = Integer.parseInt(id);
        this.image = image;
    }
    public static class3_practice_page8 newInstance(String id,String ans,String image) {
        Log.d(TAG, "newInstance");
        Log.d(TAG,"ID:::"+id);
        Log.d(TAG,"Ans:::"+ans);
        Log.d(TAG,"Image:::"+image);
        class3_practice_page8 f = new class3_practice_page8(id,ans,image);
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
        return inflater.inflate(R.layout.class3_practice_page8, container, false);
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
        String show_ans=share.getString("q8","No Answer");
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
                    editor.putString("q8",submit_ans);
                    editor.putInt("q8id",id);
                    editor.commit();
                }catch (Exception e){
                    show.setText("No Answer");
                }
                break;
            case R.id.send:
                share=getActivity().getSharedPreferences("class3_answer", Context.MODE_PRIVATE);
                getq();
                score=check_ans();
                score=score*(12.5);
                Log.d("calss3_practice_page8", "Score:::" + score);
                db_helper db=new db_helper(getActivity(),"question_db",null,1);
                long time=System.currentTimeMillis() / 1000L;
                db.record_add("3", String.valueOf(time), String.valueOf(score));
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
        q5id=share.getInt("q5id", 0);
        q6id=share.getInt("q6id", 0);
        q7id=share.getInt("q7id", 0);
        q8id=share.getInt("q8id", 0);

    }
    private double check_ans(){

        String ans1=share.getString("q1",null);
        String ans2=share.getString("q2",null);
        String ans3=share.getString("q3",null);
        String ans4=share.getString("q4",null);
        String ans5=share.getString("q5",null);
        String ans6=share.getString("q6",null);
        String ans7=share.getString("q7",null);
        String ans8=share.getString("q8",null);

        switch (q1id){
            case 1:
                if(ans1.equals("unny")){
                    point=point+1;
                }
                break;
            case 2:
                if(ans1.equals("ainy")){
                    point=point+1;
                }
                break;
            case 3:
                if(ans1.equals("indy")){
                    point=point+1;
                }
                break;
            case 4:
                if(ans1.equals("loudy")){
                    point=point+1;

                }
                break;
            case 5:
                if(ans1.equals("ot")){
                    point=point+1;

                }
                break;
            case 6:
                if(ans1.equals("arm")){
                    point=point+1;

                }
                break;
            case 7:
                if(ans1.equals("ool")){
                    point=point+1;

                }
                break;
            case 8:
                if(ans1.equals("old")){
                    point=point+1;

                }
                break;
        }
        switch (q2id){
            case 1:
                if(ans2.equals("unny")){
                    point=point+1;
                }
                break;
            case 2:
                if(ans2.equals("ainy")){
                    point=point+1;
                }
                break;
            case 3:
                if(ans2.equals("indy")){
                    point=point+1;
                }
                break;
            case 4:
                if(ans2.equals("loudy")){
                    point=point+1;

                }
                break;
            case 5:
                if(ans2.equals("ot")){
                    point=point+1;

                }
                break;
            case 6:
                if(ans2.equals("arm")){
                    point=point+1;

                }
                break;
            case 7:
                if(ans2.equals("ool")){
                    point=point+1;

                }
                break;
            case 8:
                if(ans2.equals("old")){
                    point=point+1;

                }
                break;
        }
        switch (q3id){
            case 1:
                if(ans3.equals("unny")){
                    point=point+1;
                }
                break;
            case 2:
                if(ans3.equals("ainy")){
                    point=point+1;
                }
                break;
            case 3:
                if(ans3.equals("indy")){
                    point=point+1;
                }
                break;
            case 4:
                if(ans3.equals("loudy")){
                    point=point+1;

                }
                break;
            case 5:
                if(ans3.equals("ot")){
                    point=point+1;

                }
                break;
            case 6:
                if(ans3.equals("arm")){
                    point=point+1;

                }
                break;
            case 7:
                if(ans3.equals("ool")){
                    point=point+1;

                }
                break;
            case 8:
                if(ans3.equals("old")){
                    point=point+1;

                }
                break;

        }
        switch (q4id){
            case 1:
                if(ans4.equals("unny")){
                    point=point+1;
                }
                break;
            case 2:
                if(ans4.equals("ainy")){
                    point=point+1;
                }
                break;
            case 3:
                if(ans4.equals("indy")){
                    point=point+1;
                }
                break;
            case 4:
                if(ans4.equals("loudy")){
                    point=point+1;

                }
                break;
            case 5:
                if(ans4.equals("ot")){
                    point=point+1;

                }
                break;
            case 6:
                if(ans4.equals("arm")){
                    point=point+1;

                }
                break;
            case 7:
                if(ans4.equals("ool")){
                    point=point+1;

                }
                break;
            case 8:
                if(ans4.equals("old")){
                    point=point+1;

                }
                break;
        }
        switch (q5id){
            case 1:
                if(ans5.equals("unny")){
                    point=point+1;
                }
                break;
            case 2:
                if(ans5.equals("ainy")){
                    point=point+1;
                }
                break;
            case 3:
                if(ans5.equals("indy")){
                    point=point+1;
                }
                break;
            case 4:
                if(ans5.equals("loudy")){
                    point=point+1;

                }
                break;
            case 5:
                if(ans5.equals("ot")){
                    point=point+1;

                }
                break;
            case 6:
                if(ans5.equals("arm")){
                    point=point+1;

                }
                break;
            case 7:
                if(ans5.equals("ool")){
                    point=point+1;

                }
                break;
            case 8:
                if(ans5.equals("old")){
                    point=point+1;

                }
                break;
        }
        switch (q6id){
            case 1:
                if(ans6.equals("unny")){
                    point=point+1;
                }
                break;
            case 2:
                if(ans6.equals("ainy")){
                    point=point+1;
                }
                break;
            case 3:
                if(ans6.equals("indy")){
                    point=point+1;
                }
                break;
            case 4:
                if(ans6.equals("loudy")){
                    point=point+1;

                }
                break;
            case 5:
                if(ans6.equals("ot")){
                    point=point+1;

                }
                break;
            case 6:
                if(ans6.equals("arm")){
                    point=point+1;

                }
                break;
            case 7:
                if(ans6.equals("ool")){
                    point=point+1;

                }
                break;
            case 8:
                if(ans6.equals("old")){
                    point=point+1;

                }
                break;
        }
        switch (q7id){
            case 1:
                if(ans7.equals("unny")){
                    point=point+1;
                }
                break;
            case 2:
                if(ans7.equals("ainy")){
                    point=point+1;
                }
                break;
            case 3:
                if(ans7.equals("indy")){
                    point=point+1;
                }
                break;
            case 4:
                if(ans7.equals("loudy")){
                    point=point+1;

                }
                break;
            case 5:
                if(ans7.equals("ot")){
                    point=point+1;

                }
                break;
            case 6:
                if(ans7.equals("arm")){
                    point=point+1;

                }
                break;
            case 7:
                if(ans7.equals("ool")){
                    point=point+1;

                }
                break;
            case 8:
                if(ans7.equals("old")){
                    point=point+1;

                }
                break;
        }
        switch (q8id){
            case 1:
                if(ans8.equals("unny")){
                    point=point+1;
                }
                break;
            case 2:
                if(ans8.equals("ainy")){
                    point=point+1;
                }
                break;
            case 3:
                if(ans8.equals("indy")){
                    point=point+1;
                }
                break;
            case 4:
                if(ans8.equals("loudy")){
                    point=point+1;

                }
                break;
            case 5:
                if(ans8.equals("ot")){
                    point=point+1;

                }
                break;
            case 6:
                if(ans8.equals("arm")){
                    point=point+1;

                }
                break;
            case 7:
                if(ans8.equals("ool")){
                    point=point+1;

                }
                break;
            case 8:
                if(ans8.equals("old")){
                    point=point+1;

                }
                break;
        }
        Log.d("calss3_practice_page8","Point::"+point);
        return point;
    }


}
