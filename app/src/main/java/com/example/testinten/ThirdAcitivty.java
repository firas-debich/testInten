
package com.example.testinten;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

public class ThirdAcitivty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button btn = findViewById(R.id.btn2);
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(ThirdAcitivty.this, MainActivity.class);
                        EditText addr = findViewById(R.id.addr);
                        EditText mdp1 = findViewById(R.id.mpds1);
                        EditText mdp2 = findViewById(R.id.mpds2);
                        if (!mdp1.getText().toString() .equals(mdp2.getText().toString()) ){
                            Toast.makeText(ThirdAcitivty.this,"check password",Toast.LENGTH_SHORT).show();
                        }else if (mdp1.getText().toString().equals(mdp2.getText().toString())){
                            intent.putExtra("addr",addr.getText().toString());
                            intent.putExtra("mdps",mdp1.getText().toString());
                           setResult(ThirdAcitivty.RESULT_OK,intent);
                           finish();
                        }

                    }
                }
        );
    }
}