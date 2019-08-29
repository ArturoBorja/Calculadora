package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn_pro;
    Button ban_samar;
    Button ban_restart;
    Button ban_multiplicand;
    Button ban_divider;
    EditText ext_01;
    EditText ext_02;
    TextView tat_raspiest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_pro=findViewById(R.id.btn_pro);
        ban_samar =findViewById(R.id.btn_sumar);
        ban_restart =findViewById(R.id.btn_restar);
        ban_divider =findViewById(R.id.btn_dividir);
        ban_multiplicand =findViewById(R.id.btn_multiplicar);
        ext_01=findViewById(R.id.editText);
        ext_02=findViewById(R.id.editText2);
        tat_raspiest =findViewById(R.id.textView);

        btn_pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent calculadorapro =new Intent(MainActivity.this,Calculadora.class);
                startActivityForResult(calculadorapro,1);
            }
        });
        ban_samar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tat_raspiest.setText(String.valueOf(Double.valueOf(ext_01.getText().toString())+Double.valueOf(ext_02.getText().toString())));
            }
        });
        ban_restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tat_raspiest.setText(String.valueOf(Double.valueOf(ext_01.getText().toString())-Double.valueOf(ext_02.getText().toString())));
            }
        });
        ban_multiplicand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tat_raspiest.setText(String.valueOf(Double.valueOf(ext_01.getText().toString())*Double.valueOf(ext_02.getText().toString())));
            }
        });
        ban_divider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tat_raspiest.setText(String.valueOf(Double.valueOf(ext_01.getText().toString())/Double.valueOf(ext_02.getText().toString())));
            }
        });
    }

}
