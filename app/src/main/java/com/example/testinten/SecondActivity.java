


package com.example.testinten;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        Intent intent = getIntent();
        String address = intent.getStringExtra("addr");
        String password = intent.getStringExtra("mdps");
        EditText text1 = findViewById(R.id.text1);
        EditText text2 = findViewById(R.id.text2);
        text1.setText(address);
        text2.setText(password);

        Button btn = findViewById(R.id.btn55);
        btn.setOnClickListener( 
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText text1 = findViewById(R.id.text1);
                        EditText text2 = findViewById(R.id.text2);
                        if (!text1.getText().toString().contains("@")){
                            Toast.makeText(SecondActivity.this,"email should have @",Toast.LENGTH_SHORT).show();
                            return;
                        }else if (text2.getText().toString().length() <8){
                            Toast.makeText(SecondActivity.this,"password length at least 8 caractere",Toast.LENGTH_SHORT).show();
                            return;
                        }
                        setResult(SecondActivity.RESULT_OK,intent);
                        finish();
                    }
                }
        );

    }
}
