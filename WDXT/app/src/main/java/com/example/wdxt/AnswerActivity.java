package com.example.wdxt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity {
    OnClickListener listener2;
    Button btn2;
    EditText et2;
    TextView tv2;
    static final String QUESTION = "QUESTION";
    static final String ANSWER = "ANSWER";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        tv2 = (TextView)findViewById(R.id.tv2);
        btn2 = (Button)findViewById(R.id.btn2);
        et2 = (EditText)findViewById(R.id.et2);
        listener2 = new OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                String anw = et2.getText().toString();
                bundle.putString(ANSWER,anw);
                Intent intent2 = new Intent();
                intent2.putExtras(bundle);
                setResult(RESULT_OK,intent2);
                finish();
            }
        };
        btn2.setOnClickListener(listener2);
        String data = null;
        Bundle extras =getIntent().getExtras();
        if (extras != null){
            data = extras.getString(QUESTION);
        }
        tv2.setText(data);
    }

}
