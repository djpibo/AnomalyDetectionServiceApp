package com.example.anomalydetectionservice;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SettingActivity extends AppCompatActivity {

    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8;
    String check[] = {"on","on","on","on","on","on","on","on"};

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("UserMachine").child("Machine1").child("AlarmCode");
    DatabaseReference createRef = database.getReference("UserMachine").child("UserCondition").child("AlarmPriority");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        setTitle("Setting Alarm Condition");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true); //홈 아이콘 표시 설정
        actionBar.setDisplayHomeAsUpEnabled(true); //아이콘을 Up 이미지로 표시 설정
        actionBar.setDisplayShowTitleEnabled(true); //타이틀 문자열 표시 설정
        actionBar.setDisplayUseLogoEnabled(true); //로고 표시 설정

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        tv5 = findViewById(R.id.tv5);
        tv6 = findViewById(R.id.tv6);
        tv7 = findViewById(R.id.tv7);
        tv8 = findViewById(R.id.tv8);

        myRef.child("test").setValue("erp");
        createRef.child("con1").setValue("5");
        createRef.child("con2").setValue("5");
        createRef.child("con3").setValue("5");
        createRef.child("con4").setValue("5");
        createRef.child("con5").setValue("5");
        createRef.child("con6").setValue("5");
        createRef.child("con7").setValue("5");
        createRef.child("con8").setValue("5");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                check[0] = dataSnapshot.child("con1").getValue(String.class);
                check[1] = dataSnapshot.child("con2").getValue(String.class);
                check[2] = dataSnapshot.child("con3").getValue(String.class);
                check[3] = dataSnapshot.child("con4").getValue(String.class);
                check[4] = dataSnapshot.child("con5").getValue(String.class);
                check[5] = dataSnapshot.child("con6").getValue(String.class);
                check[6] = dataSnapshot.child("con7").getValue(String.class);
                check[7] = dataSnapshot.child("con8").getValue(String.class);
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check[0].equals("on")){
                    tv1.setTextColor(Color.RED);
                    myRef.child("con1").setValue("off");
                }
                else{
                    tv1.setTextColor(Color.BLACK);
                    myRef.child("con1").setValue("on");
                }
            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check[1].equals("on")){
                    tv2.setTextColor(Color.RED);
                    myRef.child("con2").setValue("off");
                }
                else{
                    tv2.setTextColor(Color.BLACK);
                    myRef.child("con2").setValue("on");
                }
            }
        });
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check[2].equals("on")){
                    tv3.setTextColor(Color.RED);
                    myRef.child("con3").setValue("off");
                }
                else{
                    tv3.setTextColor(Color.BLACK);
                    myRef.child("con3").setValue("on");
                }
            }
        });
        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check[3].equals("on")){
                    tv4.setTextColor(Color.RED);
                    myRef.child("con4").setValue("off");
                }
                else{
                    tv4.setTextColor(Color.BLACK);
                    myRef.child("con4").setValue("on");
                }
            }
        });
        tv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check[4].equals("on")){
                    tv5.setTextColor(Color.RED);
                    myRef.child("con5").setValue("off");
                }
                else{
                    tv5.setTextColor(Color.BLACK);
                    myRef.child("con5").setValue("on");
                }
            }
        });
        tv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check[5].equals("on")){
                    tv6.setTextColor(Color.RED);
                    myRef.child("con6").setValue("off");
                }
                else{
                    tv6.setTextColor(Color.BLACK);
                    myRef.child("con6").setValue("on");
                }
            }
        });
        tv7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check[6].equals("on")){
                    tv7.setTextColor(Color.RED);
                    myRef.child("con7").setValue("off");
                }
                else{
                    tv7.setTextColor(Color.BLACK);
                    myRef.child("con7").setValue("on");
                }
            }
        });
        tv8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check[7].equals("on")){
                    tv8.setTextColor(Color.RED);
                    myRef.child("con8").setValue("off");
                }
                else{
                    tv8.setTextColor(Color.BLACK);
                    myRef.child("con8").setValue("on");
                }
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
