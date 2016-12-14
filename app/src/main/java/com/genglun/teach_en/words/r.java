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
public class r extends AppCompatActivity implements View.OnClickListener {
    private MediaPlayer mp;
    private static final String TAG="r";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.r);
        FloatingActionButton r_voice = (FloatingActionButton) findViewById(R.id.voice);
        r_voice.setOnClickListener(this);
        FloatingActionButton home = (FloatingActionButton) findViewById(R.id.home);
        home.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int resid=0;
        switch (view.getId()){
            case R.id.voice:
                resid=R.raw.r;
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
                r.this.finish();
                break;
        }
    }
}
