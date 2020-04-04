package com.example.monster_electricity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.DecimalFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

@RequiresApi(api = Build.VERSION_CODES.N)
public class Standard_SavedActivity extends AppCompatActivity {

    EditText editText ;
    Button caculates;
    TextView textView;
    double double_cost = 0,wat = 0;                                                      //計算花費
    String string_cost;                                                          //輸出花費
    private DecimalFormat decimalFormat = new DecimalFormat("#,###.#"); //四捨五入，並取小數後0位,以金額方式顯示
    private DecimalFormat hundreddecimalformat = new DecimalFormat("###.#");
    private DecimalFormat tendecimalformat = new DecimalFormat("##.#");
    private RadioGroup mRg_standard_saved;                                       //單選事件
    private  RadioButton rb_summer,rb_not_summer;                                //單選事件按鈕
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard__saved);

        editText = findViewById(R.id.wat);                      //輸入瓦特
        caculates = findViewById(R.id.caculate);                 //計算按鈕
        textView = findViewById(R.id.standard_saved_money);      //用以顯示金額
        mRg_standard_saved = findViewById(R.id.rg_saved);        //單選事件1
        rb_summer = findViewById(R.id.rb_summer);               //夏季電價按鈕
        rb_not_summer = findViewById(R.id.rb_not_summer);       //非夏季電價按鈕

        mRg_standard_saved.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { //偵測選定的按鈕
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.rb_summer) //夏季電價事件
                {
                    //計算按鈕
                    caculates.setOnClickListener(new View.OnClickListener() {
                        @RequiresApi(api = Build.VERSION_CODES.N)
                        @Override
                        public void onClick(View v) {
                            if(editText.getText().toString().length() == 0){ //必須確認是否有輸入,若無此行,則會閃退
                                textView.setText("0");
                            }
                            wat = Double.parseDouble(editText.getText().toString()); //將輸入轉為double,用以計算
                            if(wat <= 120)
                            {
                                double_cost = wat * 1.63;
                            }
                            else if(wat >= 121 && wat <= 330)
                            {
                                double_cost = (120 * 1.63) + ((wat - 120) * 2.38);
                            }
                            else if(wat >= 331 && wat <= 500)
                            {
                                double_cost = (120 *1.63) + ((330 - 120) * 2.38) + ((wat - 330) * 3.52);
                            }
                            else if(wat >= 501 && wat <= 700)
                            {
                                double_cost = (120 * 1.63) + ((330 - 120) * 2.38) + ((550 - 330) * 3.52) + ((wat - 500) * 4.61);
                            }
                            else if(wat >= 701 && wat <= 1000)
                            {
                                double_cost = (120 * 1.63) + ((330 - 120) * 2.38) + ((500 - 330) * 3.52) + ((700 - 501) * 4.61) + ((wat - 701) * 5.42);
                            }
                            else if(wat >=1001)
                            {
                                double_cost = (120 * 1.63) + ((330 - 120) * 2.38) + ((500 - 330) * 3.52) + ((700 - 501) * 4.61) + ((1000 - 701) * 5.42) + ((wat - 10001) * 6.13);
                            }
                            if(double_cost < 100){
                                string_cost = tendecimalformat.format(double_cost);
                            }
                            else if(double_cost >=100 && double_cost <1000){
                                string_cost = hundreddecimalformat.format(double_cost);
                            }
                            else {
                                string_cost = decimalFormat.format(double_cost); //轉換格式
                            }
                            textView.setText(string_cost + "元"); //顯示金額,但須先轉換成String
                        }
                    });
                }
                else  //非夏季電價事件
                {
                    //計算按鈕
                    caculates.setOnClickListener(new View.OnClickListener() {
                        @RequiresApi(api = Build.VERSION_CODES.N)
                        @Override
                        public void onClick(View v) {
                            if(editText.getText().toString().length() == 0){
                                textView.setText("0");
                            }
                            wat = Double.parseDouble(editText.getText().toString());
                            if(wat <= 120)
                            {
                                double_cost = wat * 1.63;
                            }
                            else if(wat >= 121 && wat <= 330)
                            {
                                double_cost = (120 * 1.63) + ((wat - 120) * 2.1);
                            }
                            else if(wat >= 331 && wat <= 500)
                            {
                                double_cost = (120 *1.63) + ((330 - 120) * 2.1) + ((wat - 330) * 2.89);
                            }
                            else if(wat >= 501 && wat <= 700)
                            {
                                double_cost = (120 * 1.63) + ((330 - 120) * 2.1) + ((550 - 330) * 2.89) + ((wat - 500) * 3.79);
                            }
                            else if(wat >= 701 && wat <= 1000)
                            {
                                double_cost = (120 * 1.63) + ((330 - 120) * 2.1) + ((500 - 330) * 2.89) + ((700 - 501) * 3.79) + ((wat - 701) * 4.42);
                            }
                            else if(wat >=1001)
                            {
                                double_cost = (120 * 1.63) + ((330 - 120) * 2.1) + ((500 - 330) * 2.89) + ((700 - 501) * 3.79) + ((1000 - 701) * 4.42) + ((wat - 10001) * 4.83);
                            }
                            if(double_cost < 100){
                                string_cost = tendecimalformat.format(double_cost);
                            }
                            else if(double_cost >=100 && double_cost <1000){
                                string_cost = hundreddecimalformat.format(double_cost);
                            }
                            else {
                                string_cost = decimalFormat.format(double_cost); //轉換格式
                            }
                            textView.setText(string_cost + "元"); //顯示金額,但須先轉換成String
                        }
                    });
                }
            }
        });
    }
}