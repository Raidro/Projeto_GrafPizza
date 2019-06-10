package com.example.graficoeleicoes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtVoto1, edtVoto2, edtVoto3;
    Button btnGrafico;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtVoto1 = (EditText) findViewById(R.id.edtVoto1);
        edtVoto2 = (EditText) findViewById(R.id.edtVoto2);
        edtVoto3 = (EditText) findViewById(R.id.edtVoto3);
        btnGrafico = (Button) findViewById(R.id.btnGrafico);

        btnGrafico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gerarGrafico();
            }
        });
    }

    private void gerarGrafico() {

        /* Converter e pegar valores dos votos*/

        float v1 = 0, v2 = 0, v3 = 0;
        try {
            v1 = Float.parseFloat(edtVoto1.getText().toString());
            v2 = Float.parseFloat(edtVoto2.getText().toString());
            v3 = Float.parseFloat(edtVoto3.getText().toString());

        } catch (Exception e) {

        }


        Intent graficoPizza = new Intent(MainActivity.this, myPieChart.class);
        graficoPizza.putExtra("V1", v1);
        graficoPizza.putExtra("V2", v2);
        graficoPizza.putExtra("V3", v3);
        startActivity(graficoPizza);

    }
}
