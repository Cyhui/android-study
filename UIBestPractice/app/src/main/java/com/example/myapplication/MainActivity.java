package com.example.myapplication;

import android.media.SoundPool;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Msg> mList = new ArrayList<Msg>();

    private EditText inputText;

    private Button send;

    private RecyclerView msgRecyclerView;

    private MsgAdapter adapter;

    private SoundPool soundPool;//声明一个SoundPool
    private int soundID;//创建某个声音对应的音频ID

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化消息数据
        initMsgs();
        initSound();
        inputText = (EditText) findViewById(R.id.input_text);
        send = (Button) findViewById(R.id.send);
        msgRecyclerView = (RecyclerView) findViewById(R.id.msg_recycler_view);

        LinearLayoutManager layoutMananger = new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(layoutMananger);

        adapter = new MsgAdapter(mList);
        msgRecyclerView.setAdapter(adapter);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                if (!"".equals(content)) {
                    Msg msg = new Msg(content, Msg.TYPE_SENT);
                    mList.add(msg);
                    adapter.notifyItemInserted(mList.size() - 1);//当有新消息时，刷新ListView中的显示
                    msgRecyclerView.scrollToPosition(mList.size() - 1);//将ListView定位到最后一行
                    inputText.setText("");//清空输入框中的内容
                    playSound();
                }
            }
        });

    }

    private void initSound() {
        soundPool = new SoundPool.Builder().build();
        soundID = soundPool.load(this,R.raw.sou,1);
    }

    private void playSound() {
        soundPool.play(
                soundID,
                0.1f,   //左耳道音量【0~1】
                0.5f,   //右耳道音量【0~1】
                0,      //播放优先级【0表示最低优先级】
                1,      //循环模式【0表示循环一次，-1表示一直循环，其他表示数字+1表示当前数字对应的循环次数】
                1       //播放速度【1是正常，范围从0~2】
        );
    }

    //初始化消息数据
    private void initMsgs() {
        Msg msg1 = new Msg("hello hui", Msg.TYPE_RECEIVED);
        mList.add(msg1);
        Msg msg2 = new Msg("hello. Who is that?", Msg.TYPE_SENT);
        mList.add(msg2);
        Msg msg3 = new Msg(" -_- ", Msg.TYPE_RECEIVED);
        mList.add(msg3);
        Msg msg4 = new Msg("This is Tom.Nice talking to you.", Msg.TYPE_RECEIVED);
        mList.add(msg4);
    }
}
