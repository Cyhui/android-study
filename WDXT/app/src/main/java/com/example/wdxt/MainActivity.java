package com.example.wdxt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    OnClickListener listener1;
    TextView tv1;
    Button btn1;
    EditText et1;
    static final String QUESTION = "QUESTION";
    static final String ANSWER = "ANSWER";
    static final int REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView)findViewById(R.id.tv1);
        btn1 = (Button)findViewById(R.id.btn1);
        et1 = (EditText)findViewById(R.id.et1);
        listener1 = new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this,AnswerActivity.class);
                String ett = et1.getText().toString();
                intent1.putExtra(QUESTION,ett);
                startActivityForResult(intent1,REQUEST_CODE);
            }
        };
        btn1.setOnClickListener(listener1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE){
            if (resultCode == RESULT_CANCELED){
                tv1.setText("错误");
            }else if (resultCode == RESULT_OK){
                String temp = null;
                Bundle extras = data.getExtras();
                if (extras != null){
                    temp = extras.getString(ANSWER);
                }
                tv1.setText(temp);
            }
        }
    }
}
