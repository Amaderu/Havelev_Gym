package com.example.havelevgym;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HelloActivity extends AppCompatActivity {

    Intent intent;
    Button btn1,btn2,btn3,btnNext;
    TextView step,answer,male,female;

    ImageButton btnFemale,btnMale;
    Resources res;
    int fragment=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        res = getResources();
        init();
        intent = new Intent(HelloActivity.this,SignInActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
    }

    @Override
    protected void onStart() {
        super.onStart();
        btnVisable(fragment);
    }

    private void init(){
        step = (TextView) findViewById(R.id.step);
        answer = (TextView) findViewById(R.id.answer);

        //step 1
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);

        //step 2
        male = (TextView) findViewById(R.id.tvMale);
        female = (TextView) findViewById(R.id.tvFemale);
        btnFemale = (ImageButton) findViewById(R.id.btnFemale);
        btnMale = (ImageButton) findViewById(R.id.btnMale);
        btnNext = (Button) findViewById(R.id.btnNext);

        listeners();
    }

    private void btnVisable(int step){
        switch (step){
            case 1:{
                btn1.setVisibility(View.VISIBLE);
                btn2.setVisibility(View.VISIBLE);
                btn3.setVisibility(View.VISIBLE);
            }
            case 2:{
                btn1.setVisibility(View.GONE);
                btn2.setVisibility(View.GONE);
                btn3.setVisibility(View.GONE);
                this.step.setText("Step "+step+"/5");
                this.answer.setText(R.string.answer_2);

                btnMale.setVisibility(View.VISIBLE);
                btnFemale.setVisibility(View.VISIBLE);
                btnNext.setVisibility(View.VISIBLE);
            }
            case 3:{
                btnMale.setVisibility(View.GONE);
                btnFemale.setVisibility(View.GONE);
                btnNext.setVisibility(View.GONE);

                male.setVisibility(View.GONE);
                female.setVisibility(View.GONE);

                this.step.setText("Step "+step+"/5");
                this.answer.setText(R.string.answer_3);


            }
            default:{
                Button[] btns = new Button[]{btn1,btn3,btn3,btnNext};
                for(Button btn: btns){
                    btn.setVisibility(View.GONE);
                }
            }
        }


    }
    private void listeners(){
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment++;
                onStart();
            }
        };
        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
        btn3.setOnClickListener(listener);

        btnFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Drawable male = ResourcesCompat.getDrawable(res, R.drawable.ico_male, null);
                Drawable whiteShape = ResourcesCompat.getDrawable(res, R.drawable.pressed_round, null);
                Drawable selectedShape = ResourcesCompat.getDrawable(res, R.drawable.round, null);
                v.setBackground(selectedShape);
                btnMale.setBackground(whiteShape);

            }
        });
        btnMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Drawable male = ResourcesCompat.getDrawable(res, R.drawable.ico_male, null);
                Drawable whiteShape = ResourcesCompat.getDrawable(res, R.drawable.pressed_round, null);
                Drawable selectedShape = ResourcesCompat.getDrawable(res, R.drawable.round, null);
                v.setBackground(selectedShape);
                btnFemale.setBackground(whiteShape);
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnVisable(3);
            }
        });

    }

    private void stepping2(){
        step.setText("Step "+2+"/5");
        Resources res = getResources();
        Drawable male = ResourcesCompat.getDrawable(res, R.drawable.ico_male, null);
        Drawable shape = ResourcesCompat.getDrawable(res, R.drawable.round_buttons, null);
        int[] states = btn1.getDrawableState();
        for(int state : states){
            Toast.makeText(HelloActivity.this,String.valueOf(state)+"\n"+btn1.getHeight()+"\n"+btn1.getWidth(),(int) 1).show();
        }
        //ImageButton button;
        btn1.setMaxWidth(150);
        btn1.setMaxHeight(150);
        /*btn1.setLayoutParams(new ConstraintLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));*/
        btn1.setText("");
        btn1.setBackground(shape);
        btn1.setCompoundDrawables(null,null,null,null);
        btn1.setBackgroundResource(R.drawable.ico_male);
    }


}