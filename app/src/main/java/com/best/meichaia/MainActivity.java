package com.best.meichaia;


import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;
import com.best.fragment.AboutFragment;
import com.best.fragment.BrandFragment;
import com.best.fragment.FabuFragment;
import com.best.fragment.FaxianFragment;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    RadioButton at,at2,share,location;
    FragmentManager fm ;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        at=(RadioButton)findViewById(R.id.at);
        at2=(RadioButton)findViewById(R.id.at2);
        share=(RadioButton)findViewById(R.id.share);
        location=(RadioButton)findViewById(R.id.location);

        location.setChecked(true);
        at.setOnClickListener(this);
        at2.setOnClickListener(this);
        share.setOnClickListener(this);
        location.setOnClickListener(this);

        fm = getSupportFragmentManager();

        if(savedInstanceState==null){
            FragmentTransaction ftt=fm.beginTransaction();
            BrandFragment bf=new BrandFragment();
            ftt.add(R.id.fragment_parent,bf,"location");
            ftt.commit();
        }

    }

    @Override
    public void onClick(View v) {
        //开启一个事务
        FragmentTransaction ftt = fm.beginTransaction();
        if(fm.findFragmentByTag("location")!=null){
            ftt.hide(fm.findFragmentByTag("location"));
        }
        if(fm.findFragmentByTag("share")!=null){
            ftt.hide(fm.findFragmentByTag("share"));
        }
        if(fm.findFragmentByTag("at")!=null){
            ftt.hide(fm.findFragmentByTag("at"));
        }
        if(fm.findFragmentByTag("at2")!=null){
            ftt.hide(fm.findFragmentByTag("at2"));
        }

        int id = v.getId();
        if(id== R.id.location) {
            if(fm.findFragmentByTag("location")!=null){
                ftt.show(fm.findFragmentByTag("location"));
            }else{
                BrandFragment bf = new BrandFragment();
                //add(父布局ID，Fragment,Tag);
                ftt.add(R.id.fragment_parent,bf,"location");

            }

        }else if(id == R.id.share){
            if(fm.findFragmentByTag("share")!=null){
                ftt.show(fm.findFragmentByTag("share"));
//                toolbar.setTitle("分类");
            }else{
                FaxianFragment pf = new FaxianFragment();
                ftt.add(R.id.fragment_parent, pf, "share");

            }

        }else if(id==R.id.at){
            if(fm.findFragmentByTag("at")!=null){
                ftt.show(fm.findFragmentByTag("at"));
//                toolbar.setTitle("人物");
            }else {
                FabuFragment af = new FabuFragment();
                ftt.add(R.id.fragment_parent, af, "at");

            }
        }else if(id==R.id.at2){
            if(fm.findFragmentByTag("at2")!=null){
                ftt.show(fm.findFragmentByTag("at2"));
//                toolbar.setTitle("我的");
            }
            else {
                AboutFragment ff = new AboutFragment();
                ftt.add(R.id.fragment_parent, ff, "at2");

            }
        }
        ftt.commit();
    }



}
