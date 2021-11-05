package com.example.nghenhac;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class ChonNhacActivity extends AppCompatActivity {
    Button bai1,bai2,bai3,bai4,bai5,bai6,chon;
    TextView ID;
    boolean check=false;
    private static final int RC_VIDEO_APP_PERM = 124;
    int uri;
    String name="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chon_nhac);
        ID=findViewById(R.id.idbai);
        bai1=findViewById(R.id.bai1);
        bai2=findViewById(R.id.bai2);
        bai3=findViewById(R.id.bai3);
        bai4=findViewById(R.id.bai4);
        bai5=findViewById(R.id.bai5);
        bai6=findViewById(R.id.bai6);
        chon=findViewById(R.id.chon);

        chon.setOnClickListener(v->{
            if(check){
                Intent intent=new Intent(ChonNhacActivity.this,MainActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("ID",ID.getText().toString());
                intent.putExtra("path",String.valueOf(uri));
                startActivity(intent);
                finish();
            }
            else{
                Toast.makeText(ChonNhacActivity.this,"Hay chon bai truoc",Toast.LENGTH_SHORT).show();
            }
        });
        bai1.setOnClickListener(v->{
            check=true;
            ID.setText(bai1.getText().toString());
            uri = R.raw.caooc20;
            name="cao oc 20";
        });
        bai2.setOnClickListener(v->{
            check=true;
            ID.setText(bai2.getText().toString());
            uri = R.raw.castleonthehill;
            name="castle on the hill";
        });
        bai3.setOnClickListener(v->{
            check=true;
            ID.setText(bai3.getText().toString());
            uri = R.raw.dive;
            name="dive";
        });
        bai4.setOnClickListener(v->{
            check=true;
            ID.setText(bai4.getText().toString());
            uri = R.raw.idontcare;
            name="i dont care";
        });
        bai5.setOnClickListener(v->{
            check=true;
            ID.setText(bai5.getText().toString());
            uri = R.raw.nevergonnagiveyouup;
            name="never gonna give you up";
        });
        bai6.setOnClickListener(v->{
            check=true;
            ID.setText(bai6.getText().toString());
            uri = R.raw.shivers;
            name="shivers";
        });

    }



}