package com.example.monster_electricity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button mBtnStart;
    Animation fromBottom,fromTop;
    ImageView bullon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnStart = findViewById(R.id.start);
        bullon = findViewById(R.id.hot_bullon);

        fromBottom = AnimationUtils.loadAnimation(this,R.anim.frombuttom);
        fromTop = AnimationUtils.loadAnimation(this,R.anim.fromtop);

        mBtnStart.setAnimation(fromBottom);
        bullon.setAnimation(fromTop);

        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
    }
}
