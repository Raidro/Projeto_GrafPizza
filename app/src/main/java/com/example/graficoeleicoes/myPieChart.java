package com.example.graficoeleicoes;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class myPieChart extends AppCompatActivity {

    private PieChart myChart;
    List<PieEntry> valores = new ArrayList<>();
    PieDataSet dataset1;
    PieData dados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);

        myChart =  (PieChart) findViewById(R.id.minhaPizza);

        /* Receber paramentros da ActivityMain*/
        Bundle param = getIntent().getExtras();
        float v1,v2,v3;
        v1 = param.getFloat("V1");
        v2 = param.getFloat("V2");
        v3 = param.getFloat("V3");


        myChart.setUsePercentValues(true);
        myChart.setExtraOffsets(5,10,5,5);
        myChart.setDrawHoleEnabled(true);
        myChart.setHoleColor(Color.WHITE);
        myChart.setTransparentCircleRadius(31f);
        myChart.setHoleRadius(20f);

        /*Cor e fonte dos nomes*/

        myChart.setEntryLabelColor(Color.DKGRAY);
        myChart.setEntryLabelTextSize(14f);

        valores.add(new PieEntry(v1,"% Candidato 1"));
        valores.add(new PieEntry(v2,"% Candidato 2"));
        valores.add(new PieEntry(v3,"% Candidato 3"));

        /*Animacao*/
        myChart.animateY(2000, Easing.EaseInOutCubic);

        dataset1 = new PieDataSet(valores, "% Resultado dos votos");
        dataset1.setColors(ColorTemplate.PASTEL_COLORS);
        dataset1.setSliceSpace(6f);
        dados = new PieData(dataset1);
        dados.setValueTextSize(14f);
        dados.setValueTextColor(Color.DKGRAY);
        myChart.setData(dados);
    }
}
