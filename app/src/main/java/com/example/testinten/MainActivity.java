package com.example.testinten;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String address;
    String motDePasse;


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_exp,menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn3);
        ActivityResultLauncher <Intent> lancerActivity;
        lancerActivity = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult o) {
                        if (o.getResultCode() == ThirdAcitivty.RESULT_CANCELED) return;
                        if (o.getResultCode() == ThirdAcitivty.RESULT_OK) {
                            Intent donnee = o.getData();
                            String addr = donnee.getStringExtra("addr");
                            String mdps = donnee.getStringExtra("mdps");
                            address = addr.toString();
                            motDePasse = mdps.toString();
                            EditText edt1 = findViewById(R.id.edt1);
                            EditText edt2 = findViewById(R.id.edt2);
                            edt1.setText(addr);
                            edt2.setText(mdps);
                        }

                    }
                }
        );

        ActivityResultLauncher <Intent> lancerActivity2;
        lancerActivity2 = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult o) {
                        if (o.getResultCode() == SecondActivity.RESULT_CANCELED) return;
                        if (o.getResultCode() == SecondActivity.RESULT_OK) {
                            Toast.makeText(MainActivity.this,"credentiale valid ",Toast.LENGTH_SHORT).show();

                        }

                    }
                }
        );




        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, ThirdAcitivty.class);
                        lancerActivity.launch(intent);
                    }
                }
        );
        btn2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                        EditText edt1 = findViewById(R.id.edt1);
                        EditText edt2 = findViewById(R.id.edt2);
                        intent.putExtra("addr",edt1.getText().toString());
                        intent.putExtra("mdps",edt2.getText().toString());
                        lancerActivity2.launch(intent);
                    }
                }
        );



    }


}