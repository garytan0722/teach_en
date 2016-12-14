package com.genglun.teach_en;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.genglun.teach_en.class1.class1_main_activity;
import com.genglun.teach_en.class2.class2_main_activity;
import com.genglun.teach_en.class3.class3_main_activity;
import com.genglun.teach_en.practice.practice;
import com.genglun.teach_en.setting.record;
import com.genglun.teach_en.sql.db_helper;
import com.genglun.teach_en.words.a;
import com.genglun.teach_en.words.b;
import com.genglun.teach_en.words.c;
import com.genglun.teach_en.words.d;
import com.genglun.teach_en.words.e;
import com.genglun.teach_en.words.f;
import com.genglun.teach_en.words.g;
import com.genglun.teach_en.words.h;
import com.genglun.teach_en.words.i;
import com.genglun.teach_en.words.j;
import com.genglun.teach_en.words.k;
import com.genglun.teach_en.words.l;
import com.genglun.teach_en.words.m;
import com.genglun.teach_en.words.n;
import com.genglun.teach_en.words.o;
import com.genglun.teach_en.words.p;
import com.genglun.teach_en.words.q;
import com.genglun.teach_en.words.r;
import com.genglun.teach_en.words.s;
import com.genglun.teach_en.words.t;
import com.genglun.teach_en.words.u;
import com.genglun.teach_en.words.v;
import com.genglun.teach_en.words.w;
import com.genglun.teach_en.words.x;
import com.genglun.teach_en.words.y;
import com.genglun.teach_en.words.z;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db_helper db=new db_helper(getApplicationContext(),"question_db",null,1);
        db.getReadableDatabase();
        db.close();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setbtn();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_class1_words) {
            Intent class1_word_intent=new Intent(this, class1_main_activity.class);
            startActivity(class1_word_intent);

        }
        if (id == R.id.nav_class2_words) {
            Intent class2_word_intent=new Intent(this, class2_main_activity.class);
            startActivity(class2_word_intent);

        }
        if (id == R.id.nav_class3_words) {
            Intent class3_word_intent=new Intent(this, class3_main_activity.class);
            startActivity(class3_word_intent);
        }
        if (id == R.id.nav_practice) {
            Intent practice_intent=new Intent(this, practice.class);
            startActivity(practice_intent);
        }
        if (id == R.id.nav_record) {
            Intent record_intent=new Intent(this, record.class);
            startActivity(record_intent);
        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.a:
                Intent aintent=new Intent(this,a.class);
                startActivity(aintent);
                break;
            case R.id.b:
                Intent bintent=new Intent(this,b.class);
                startActivity(bintent);
                break;
            case R.id.c:
                Intent cintent=new Intent(this,c.class);
                startActivity(cintent);
                break;
            case R.id.d:
                Intent dintent=new Intent(this,d.class);
                startActivity(dintent);
                break;
            case R.id.e:
                Intent eintent=new Intent(this,e.class);
                startActivity(eintent);
                break;
            case R.id.f:
                Intent fintent=new Intent(this,f.class);
                startActivity(fintent);
                break;
            case R.id.g:
                Intent gintent=new Intent(this,g.class);
                startActivity(gintent);
                break;
            case R.id.h:
                Intent hintent=new Intent(this,h.class);
                startActivity(hintent);
                break;
            case R.id.i:
                Intent iintent=new Intent(this,i.class);
                startActivity(iintent);
                break;
            case R.id.j:
                Intent jintent=new Intent(this,j.class);
                startActivity(jintent);
                break;
            case R.id.k:
                Intent kintent=new Intent(this,k.class);
                startActivity(kintent);
                break;
            case R.id.l:
                Intent lintent=new Intent(this,l.class);
                startActivity(lintent);
                break;
            case R.id.m:
                Intent mintent=new Intent(this,m.class);
                startActivity(mintent);
                break;
            case R.id.n:
                Intent nintent=new Intent(this,n.class);
                startActivity(nintent);
                break;
            case R.id.o:
                Intent ointent=new Intent(this,o.class);
                startActivity(ointent);
                break;
            case R.id.p:
                Intent pintent=new Intent(this,p.class);
                startActivity(pintent);
                break;
            case R.id.q:
                Intent qintent=new Intent(this,q.class);
                startActivity(qintent);
                break;
            case R.id.r:
                Intent rintent=new Intent(this,r.class);
                startActivity(rintent);
                break;
            case R.id.s:
                Intent sintent=new Intent(this,s.class);
                startActivity(sintent);
                break;
            case R.id.t:
                Intent tintent=new Intent(this,t.class);
                startActivity(tintent);
                break;
            case R.id.u:
                Intent uintent=new Intent(this,u.class);
                startActivity(uintent);
                break;
            case R.id.v:
                Intent vintent=new Intent(this,v.class);
                startActivity(vintent);
                break;
            case R.id.w:
                Intent wintent=new Intent(this,w.class);
                startActivity(wintent);
                break;
            case R.id.x:
                Intent xintent=new Intent(this,x.class);
                startActivity(xintent);
                break;
            case R.id.y:
                Intent yintent=new Intent(this,y.class);
                startActivity(yintent);
                break;
            case R.id.z:
                Intent zintent=new Intent(this,z.class);
                startActivity(zintent);
                break;

        }

    }
    public void setbtn(){
        Button a =(Button)findViewById(R.id.a);
        Button b =(Button)findViewById(R.id.b);
        Button c =(Button)findViewById(R.id.c);
        Button d =(Button)findViewById(R.id.d);
        Button e =(Button)findViewById(R.id.e);
        Button f =(Button)findViewById(R.id.f);
        Button g =(Button)findViewById(R.id.g);
        Button h =(Button)findViewById(R.id.h);
        Button i =(Button)findViewById(R.id.i);
        Button j =(Button)findViewById(R.id.j);
        Button k =(Button)findViewById(R.id.k);
        Button l =(Button)findViewById(R.id.l);
        Button m =(Button)findViewById(R.id.m);
        Button n =(Button)findViewById(R.id.n);
        Button o =(Button)findViewById(R.id.o);
        Button p =(Button)findViewById(R.id.p);
        Button q =(Button)findViewById(R.id.q);
        Button r =(Button)findViewById(R.id.r);
        Button s =(Button)findViewById(R.id.s);
        Button t =(Button)findViewById(R.id.t);
        Button u =(Button)findViewById(R.id.u);
        Button v =(Button)findViewById(R.id.v);
        Button w =(Button)findViewById(R.id.w);
        Button x =(Button)findViewById(R.id.x);
        Button y =(Button)findViewById(R.id.y);
        Button z =(Button)findViewById(R.id.z);
        a.setOnClickListener(this);
        b.setOnClickListener(this);
        c.setOnClickListener(this);
        d.setOnClickListener(this);
        e.setOnClickListener(this);
        f.setOnClickListener(this);
        g.setOnClickListener(this);
        h.setOnClickListener(this);
        i.setOnClickListener(this);
        j.setOnClickListener(this);
        k.setOnClickListener(this);
        l.setOnClickListener(this);
        m.setOnClickListener(this);
        n.setOnClickListener(this);
        o.setOnClickListener(this);
        p.setOnClickListener(this);
        q.setOnClickListener(this);
        r.setOnClickListener(this);
        s.setOnClickListener(this);
        t.setOnClickListener(this);
        u.setOnClickListener(this);
        v.setOnClickListener(this);
        w.setOnClickListener(this);
        x.setOnClickListener(this);
        y.setOnClickListener(this);
        z.setOnClickListener(this);
    }


}
