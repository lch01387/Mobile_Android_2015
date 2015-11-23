package com.example.administrator.music;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btStart;
    Button btStop;
    MediaPlayer mMplayer;
    private ListView lv_music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btStart = (Button) findViewById(R.id.bt_start);
        btStop = (Button) findViewById(R.id.bt_stop);
        lv_music = (ListView) findViewById(R.id.lv_music);

        mMplayer = new MediaPlayer();
        // Prepare mp3 file for MediaPlayer mp3파일 불러오기
        try {
            AssetFileDescriptor afd = getResources().openRawResourceFd(R.raw.gateofsteiner);
            mMplayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
        } catch(Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        btStart.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View view){
               try {
                   mMplayer.prepare(); // 시퀀스에 나와있듯이 prepare단계가 필요하다.
                   mMplayer.start();
               } catch(Exception e) {
                   Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
               }
           }
        });

        btStop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mMplayer.stop();
            }
        });

        // Create listview
        final String[] musicList = {"gateofsteiner", "hoshiga", "lune"};
        ArrayAdapter<String> musicAdapter;
        musicAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, musicList);
        lv_music.setAdapter(musicAdapter);
        lv_music.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "click : " + musicList[position], Toast.LENGTH_LONG).show();
            }
        });
    }
}
