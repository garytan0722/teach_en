package com.genglun.teach_en.words;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.genglun.teach_en.MainActivity;
import com.genglun.teach_en.R;

/**
 * Created by garytan on 15/10/3.
 */
public class v extends AppCompatActivity implements View.OnClickListener {
    private MediaPlayer mp;
    private static final String TAG="v";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.v);
        FloatingActionButton v_voice = (FloatingActionButton) findViewById(R.id.voice);
        v_voice.setOnClickListener(this);
        FloatingActionButton home = (FloatingActionButton) findViewById(R.id.home);
        home.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int resid=0;
        switch (view.getId()){
            case R.id.voice:
                resid=R.raw.v;
                if (mp != null) {
                    mp.release();
                }
                // Create a new MediaPlayer to play this sound
                mp = MediaPlayer.create(this, resid);
                mp.start();
                break;
            case R.id.home:
                Intent intent=new Intent(this, MainActivity.class);
                startActivity(intent);
                v.this.finish();
                break;
        }
    }
}
