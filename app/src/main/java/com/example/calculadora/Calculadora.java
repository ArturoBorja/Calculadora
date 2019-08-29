package com.example.calculadora;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.MovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Calculadora extends AppCompatActivity {
    Button[] btn_numero=new Button[10];
    Button btn_dot, btn_x100, btn_borrar, btn_rest, btn_suma, btn_div, btn_por, btn_enter;
    TextView txt_opera;
    TextView txt_00;
    List<Double> memoria;
    List<String> operadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        txt_opera=findViewById(R.id.txt_opera);
        txt_00=findViewById(R.id.txt_00);
        txt_00.setMovementMethod(new ScrollingMovementMethod());
        memoria=new ArrayList<>();
        operadores=new ArrayList<>();
        CrearNumero();
        EscribirNumero();
    }
    void CrearNumero(){
        btn_numero[0]=findViewById(R.id.btn_0);
        btn_numero[1]=findViewById(R.id.btn_1);
        btn_numero[2]=findViewById(R.id.btn_2);
        btn_numero[3]=findViewById(R.id.btn_3);
        btn_numero[4]=findViewById(R.id.btn_4);
        btn_numero[5]=findViewById(R.id.btn_5);
        btn_numero[6]=findViewById(R.id.btn_6);
        btn_numero[7]=findViewById(R.id.btn_7);
        btn_numero[8]=findViewById(R.id.btn_8);
        btn_numero[9]=findViewById(R.id.btn_9);
        btn_dot=findViewById(R.id.btn_dot);
        btn_x100=findViewById(R.id.btn_x100);
        btn_borrar=findViewById(R.id.btn_borrar);
        btn_rest=findViewById(R.id.btn_rest);
        btn_suma=findViewById(R.id.btn_suma);
        btn_div=findViewById(R.id.btn_div);
        btn_por=findViewById(R.id.btn_por);
        btn_enter=findViewById(R.id.btn_enter);

    }
    void  EscribirNumero(){
        for(int a=0;a<10;a++){
            final int finalA = a;
            btn_numero[a].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   txt_opera.append(String.valueOf(finalA));
                }
            });
        }
        btn_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_opera.append(".");
            }
        });
        btn_suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_00.append(txt_opera.getText().toString()+"\n");
                memoria.add(Double.valueOf(txt_opera.getText().toString()));
                operadores.add("+");
                txt_opera.setText("");
            }
        });
        btn_rest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_00.append(txt_opera.getText().toString()+"\n");
                memoria.add(Double.valueOf(txt_opera.getText().toString()));
                operadores.add("-");
                txt_opera.setText("");
            }
        });
        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_00.append(txt_opera.getText().toString()+"\n");
                memoria.add(Double.valueOf(txt_opera.getText().toString()));
                operadores.add("/");
                txt_opera.setText("");
            }
        });
        btn_por.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_00.append(txt_opera.getText().toString()+"\n");
                memoria.add(Double.valueOf(txt_opera.getText().toString()));
                operadores.add("*");
                txt_opera.setText("");
            }
        });
        btn_x100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_00.append(txt_opera.getText().toString()+"\n");
                memoria.add(Double.valueOf(txt_opera.getText().toString()));
                operadores.add("%");
                txt_opera.setText("");
            }
        });
        btn_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double total;
                String cope;
                cope = operadores.get(operadores.size()-1);
                txt_00.append(txt_opera.getText().toString()+"\n");
                memoria.add(Double.valueOf(txt_opera.getText().toString()));
                txt_opera.setText("");
                switch(cope){
                    case "+":
                        total=(memoria.get((memoria.size()-1)))+(memoria.get((memoria.size()-2)));
                        memoria.remove(memoria.size()-1);
                        memoria.remove(memoria.size()-1);
                        operadores.remove(operadores.size()-1);
                        txt_opera.append(String.valueOf(total));
                        break;
                    case "-":
                        total=(memoria.get((memoria.size()-2)))-(memoria.get((memoria.size()-1)));
                        memoria.remove(memoria.size()-1);
                        memoria.remove(memoria.size()-1);
                        operadores.remove(operadores.size()-1);
                        txt_opera.append(String.valueOf(total));
                        break;
                    case "/":
                        total=(memoria.get((memoria.size()-2)))/(memoria.get((memoria.size()-1)));
                        memoria.remove(memoria.size()-1);
                        memoria.remove(memoria.size()-1);
                        operadores.remove(operadores.size()-1);
                        txt_opera.append(String.valueOf(total));
                        break;
                    case "*":
                        total=(memoria.get((memoria.size()-1)))*(memoria.get((memoria.size()-2)));
                        memoria.remove(memoria.size()-1);
                        memoria.remove(memoria.size()-1);
                        operadores.remove(operadores.size()-1);
                        txt_opera.append(String.valueOf(total));
                        break;
                    case "%":
                        total=(memoria.get((memoria.size()-2)))*((memoria.get((memoria.size()-1)))/100);
                        memoria.remove(memoria.size()-1);
                        memoria.remove(memoria.size()-1);
                        operadores.remove(operadores.size()-1);
                        txt_opera.append(String.valueOf(total));
                        break;
                    default:

                        break;
                }


            }
        });
        btn_borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_opera.setText("");
            }
        });
    }
}
