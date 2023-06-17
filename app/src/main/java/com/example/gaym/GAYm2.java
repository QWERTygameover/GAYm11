package com.example.gaym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class GAYm2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try{
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}

        setContentView(R.layout.activity_gaym2);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public boolean Started = false;
    public boolean Finished = false;

    public void Start(View view){
        Button button = findViewById(R.id.start);

        if(!Finished) {
            if (!Started) {
                button.setBackgroundColor(Color.GRAY);
                button.setText("Пауза");
                Started = true;
            } else if (Started) {
                button.setBackgroundColor(Color.GREEN);
                button.setText("Старт");
                Started = false;
            }
        }
        else{
            Intent intent = new Intent(GAYm2.this, GAYm2.class);
            startActivity(intent);
        }
    }

    public void Drive1(View view){
        Button button = findViewById(R.id.start);
        View car = findViewById(R.id.carone);
        TextView result = findViewById(R.id.tvResult);

        if(Started && !Finished){
            ViewGroup.MarginLayoutParams margin = (ViewGroup.MarginLayoutParams) car.getLayoutParams();
            margin.leftMargin += 40;
            margin.rightMargin -= 40;
            car.requestLayout();

            if(margin.rightMargin <= -1800){
                result.setText("Победа 1 игрока");
                button.setText("Заново");
                result.setTextColor(0xffe91e63);
                Finished = true;
            }
        }
    }
    public void Drive2(View view){
        Button button = findViewById(R.id.start);
        View car = findViewById(R.id.cartwo);
        TextView result = findViewById(R.id.tvResult);

        if(Started && !Finished){
            ViewGroup.MarginLayoutParams margin = (ViewGroup.MarginLayoutParams) car.getLayoutParams();
            margin.leftMargin += 40;
            margin.rightMargin -= 40;
            car.requestLayout();

            if(margin.rightMargin <= -1800){
                result.setText("Победа 2 игрока");
                button.setText("Заново");
                result.setTextColor(0xffe91e63);
                Finished = true;
            }
        }
    }

}