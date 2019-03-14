package com.example.hp.examenmdm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EstadisticasActivity extends AppCompatActivity {
    TextView b1, b2, b3, b4, m1, m2, m3, m4,m5,b5;
    Button Regresra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);

        this.b1 = findViewById(R.id.b1);
        this.b2 = findViewById(R.id.b2);
        this.b3 = findViewById(R.id.b3);
        this.b4 = findViewById(R.id.b4);
        this.Regresra = findViewById(R.id.Regresar);
        this.m1 = findViewById(R.id.m1);
        this.m2 = findViewById(R.id.m2);
        this.m3 = findViewById(R.id.m3);
        this.m4 = findViewById(R.id.m4);
        this.m5= findViewById(R.id.m5);
        this.b5= findViewById(R.id.b5);


        Intent intent = getIntent();
        this.b1.setText(intent.getExtras().getString("sumaB"));
        this.m1.setText(intent.getExtras().getString("sumaM"));
        this.b2.setText(intent.getExtras().getString("restaB"));
        this.m2.setText(intent.getExtras().getString("restaM"));
        this.b3.setText(intent.getExtras().getString("multiB"));
        this.m3.setText(intent.getExtras().getString("multiM"));
        this.b4.setText(intent.getExtras().getString("divB"));
        this.m4.setText(intent.getExtras().getString("divM"));
        this.m5.setText(intent.getExtras().getString("totalm"));
        this.b5.setText(intent.getExtras().getString("totalb"));

        this.Regresra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(
                        getApplicationContext(),
                        GameActivity.class
                );
                startActivity(intent);

            }

        });
    }
}
