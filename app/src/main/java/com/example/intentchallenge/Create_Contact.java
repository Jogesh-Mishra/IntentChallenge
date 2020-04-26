package com.example.intentchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Create_Contact extends AppCompatActivity implements View.OnClickListener {

    ImageView ivHappy,ivSad,ivNeutral;
    EditText etName,etNumber,etWeb,etLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__contact);

        etName=findViewById(R.id.etName);
        etNumber=findViewById(R.id.etNumber);
        etWeb=findViewById(R.id.etWeb);
        etLocation=findViewById(R.id.etLocation);

        ivHappy=findViewById(R.id.ivHappy);
        ivNeutral=findViewById(R.id.ivNeutral);
        ivSad=findViewById(R.id.ivSad);

        ivSad.setOnClickListener(this);
        ivNeutral.setOnClickListener(this);
        ivHappy.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(etName.getText().toString().isEmpty()||etNumber.getText().toString().isEmpty()||etLocation.
                getText().toString().isEmpty()||etWeb.getText().toString().isEmpty())
            Toast.makeText(this, "Please Enter the Data", Toast.LENGTH_SHORT).show();
        else{

            String name = etName.getText().toString().trim();
            String number=etNumber.getText().toString().trim();
            String location= etLocation.getText().toString().trim();
            String web=etWeb.getText().toString().trim();

            Intent intent=new Intent(Create_Contact.this,com.example.intentchallenge.MainActivity.class);

            intent.putExtra("name",name);
            intent.putExtra("number",number);
            intent.putExtra("web",web);
            intent.putExtra("loc",location);

            if(v.getId()==R.id.ivHappy)
                intent.putExtra("mood","happy");
            else if (v.getId()==R.id.ivSad)
                intent.putExtra("mood","sad");
            else
                intent.putExtra("mood","neutral");

            setResult(RESULT_OK,intent);
            Create_Contact.this.finish();
            }


        }


    }

