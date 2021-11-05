package com.example.nghenhac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button chonbai,play,pause;
    TextView tenbai,idbai,thoigian;
    String ID="",name="",tmp="";
    int path;
    private MediaPlayer mediaPlayer;
    boolean isPause=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chonbai=findViewById(R.id.chonbai);
        play=findViewById(R.id.play);
        pause=findViewById(R.id.pause);
        tenbai=findViewById(R.id.tenbai);
        idbai=findViewById(R.id.idbai);
        thoigian=findViewById(R.id.time);
        if(getIntent().getExtras().get("ID")!=null){
            ID=getIntent().getExtras().get("ID").toString();
            name=getIntent().getExtras().get("name").toString();
            tmp=getIntent().getExtras().get("path").toString();

        }
        else {
            tmp="";
            ID="";
            name="";
        }
        path=Integer.parseInt(tmp);

        if(!ID.equals("")){
            idbai.setText("bai so "+ID);
            tenbai.setText(name);
        }

        chonbai.setOnClickListener(v->{
           Intent intent = new Intent(MainActivity.this,ChonNhacActivity.class);
           startActivity(intent);
           finish();
        });

        play.setOnClickListener(v->{
            if(!ID.equals("")){
                Toast.makeText(MainActivity.this,tmp,Toast.LENGTH_SHORT).show();
                mediaPlayer= MediaPlayer.create(this,path);
                mediaPlayer.start();
            }
            else{
                Toast.makeText(MainActivity.this,"hay chon bai",Toast.LENGTH_SHORT).show();
            }
        });

        pause.setOnClickListener(v->{

            if(!ID.equals("")){

                mediaPlayer.stop();

            }
            else{
                Toast.makeText(MainActivity.this,"hay chon bai",Toast.LENGTH_SHORT).show();
            }
        });
    }
}