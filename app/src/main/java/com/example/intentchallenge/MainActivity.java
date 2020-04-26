package com.example.intentchallenge;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvResult;
    Button btnCreate;
    ImageView ivMood,ivPhone,ivMap,ivWeb;

    String name,number,map,web,mood;

    int CREATE_CONTENT =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCreate=findViewById(R.id.btnCreate);
        tvResult=findViewById(R.id.tvResult);
        ivMap=findViewById(R.id.ivMap);
        ivMood=findViewById(R.id.ivMood);
        ivPhone=findViewById(R.id.ivPhone);
        ivWeb=findViewById(R.id.ivWeb);

        ivWeb.setVisibility(View.GONE);
        ivMood.setVisibility(View.GONE);
        ivPhone.setVisibility(View.GONE);
        ivMap.setVisibility(View.GONE);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,com.example.intentchallenge.Create_Contact.class);
                startActivityForResult(intent,CREATE_CONTENT);
            }
        });

        ivPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+number));
                startActivity(intent);

            }
        });

        ivMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q="+map));
                startActivity(intent);

            }
        });

        ivWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://"+web));
                startActivity(intent);

            }
        });


         }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==CREATE_CONTENT){
            if(resultCode==RESULT_OK){
                ivWeb.setVisibility(View.VISIBLE);
                ivMood.setVisibility(View.VISIBLE);
                ivPhone.setVisibility(View.VISIBLE);
                ivMap.setVisibility(View.VISIBLE);

                name = data.getStringExtra("name");
                number =data.getStringExtra("number");
                map=data.getStringExtra("loc");
                web = data.getStringExtra("web");
                mood=data.getStringExtra("mood");

                if(mood.equals("happy"))
                    ivMood.setImageResource(R.drawable.ic_happy_24dp);
                else if (mood.equals("sad"))
                    ivMood.setImageResource(R.drawable.ic_poor_24dp);
                else
                    ivMood.setImageResource(R.drawable.ic_neutral_24dp);
            }

    }
        else
            Toast.makeText(this, "NO DATA PASSED", Toast.LENGTH_SHORT).show();
}
}
