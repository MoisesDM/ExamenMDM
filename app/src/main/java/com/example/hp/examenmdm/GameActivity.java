package com.example.hp.examenmdm;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp.examenmdm.Entidades.Datos;

import java.text.BreakIterator;
import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {
    private ArrayList<Datos> mList;
    private Adapteroperaciones mAdapter;
    Button btnGenrar, btnvalidar, btnestadistica;
    private TextView num;
    TextView su, sm, res, rm, mu, mm, di, dm;
    EditText numu;
    ImageView va;
    int suma = 0, resta = 0, multiplicacion = 0, divicion = 0;
    int sumam = 0, restam = 0, multiplicacionm = 0, divicionm = 0;
    int rsuma, rresta, rmulti, rdivicion;
    Spinner spinnerCountries;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        initList();
        spinnerCountries = findViewById(R.id.spOperacions);
        num = findViewById(R.id.numero1);
        numu = findViewById(R.id.usuarioNum);
        va = findViewById(R.id.check);
        btnGenrar = findViewById(R.id.Generarnum);
        btnestadistica = findViewById(R.id.VerEstadisticas);
        btnvalidar = findViewById(R.id.ValidarR);

        this.su = findViewById(R.id.tbsuma);
        this.sm = findViewById(R.id.tmsuma);
        this.res = findViewById(R.id.tbresta);
        this.rm = findViewById(R.id.tmresta);
        this.mu = findViewById(R.id.tbMultiplicacon);
        this.mm = findViewById(R.id.tmMultiplicacon);
        this.di = findViewById(R.id.tbdivicion);
        this.dm = findViewById(R.id.tmdivicion);


        mAdapter = new Adapteroperaciones(this, mList);
        spinnerCountries.setAdapter(mAdapter);

        spinnerCountries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Datos clickedItem = (Datos) parent.getItemAtPosition(position);
                String clickedCountryName = clickedItem.getOpereciones();
                Numeros(clickedCountryName);
                Toast.makeText(GameActivity.this, clickedCountryName, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btnestadistica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int b=suma+resta+multiplicacion+divicion;
                int m=sumam+restam+multiplicacionm+divicionm;
                Intent intent = new Intent(v.getContext(), EstadisticasActivity.class);
                intent.putExtra("sumaB", su.getText());
                intent.putExtra("sumaM", sm.getText());
                intent.putExtra("restaB", res.getText());
                intent.putExtra("restaM", rm.getText());
                intent.putExtra("multiB", mu.getText());
                intent.putExtra("multiM", mm.getText());
                intent.putExtra("multiB", di.getText());
                intent.putExtra("divM", dm.getText());
                intent.putExtra("totalb",String.valueOf(b));
                intent.putExtra("totalm",String.valueOf(m));
                startActivity(intent);
            }
        });


    }

    public void Numeros(String clickedCountryName) {
        if (clickedCountryName.equals("Eliga una opcion")) {
            this.btnGenrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(GameActivity.this, "opcion invalida", Toast.LENGTH_SHORT).show();
                }
            });
        } else if (clickedCountryName.equals("Suma")) {
            this.btnGenrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int num1, num2, maximo = 9999, min = 1;
                    num1 = (int) (Math.random() * 100);
                    num2 = (int) (Math.random() * 100);
                    String cad;
                    rsuma = num1 + num2;
                    cad = num1 + "+" + num2;
                    num.setText(cad);
                }
            });
            btnvalidar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        int RsultadoU = Integer.parseInt(numu.getText().toString());
                        if (RsultadoU == rsuma) {
                            va.setImageDrawable(getDrawable(R.drawable.ic_action_bien));
                            suma += 1;
                            su.setText(String.valueOf(suma));
                            num.setText("");
                            numu.setText("");
                        } else {
                            va.setImageDrawable(getDrawable(R.drawable.ic_action_error));
                            sumam++;
                            sm.setText(String.valueOf(sumam));
                            num.setText("");
                            numu.setText("");
                        }
                    } catch (Exception e) {
                        Toast.makeText(GameActivity.this, "Ya validaste esta respuesta ", Toast.LENGTH_SHORT).show();
                        num.setText("");
                        numu.setText("");
                    }

                }
            });

        } else if (clickedCountryName.equals("Resta")) {
            this.btnGenrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int num1, num2, maximo = 9999, min = 1;
                    num1 = (int) (Math.random() * 100);
                    num2 = (int) (Math.random() * 100);
                    String cad;
                    rresta = num1 - num2;
                    cad = num1 + "-" + num2;
                    num.setText(cad);
                }
            });
            btnvalidar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        int RsultadoU = Integer.parseInt(numu.getText().toString());
                        if (RsultadoU == rresta) {
                            va.setImageDrawable(getDrawable(R.drawable.ic_action_bien));
                            resta++;
                            res.setText(String.valueOf(resta));
                            num.setText("");
                            numu.setText("");
                        } else {
                            va.setImageDrawable(getDrawable(R.drawable.ic_action_error));
                            restam++;

                            rm.setText(String.valueOf(restam));

                            num.setText("");
                            numu.setText("");
                        }

                    } catch (Exception e) {
                        Toast.makeText(GameActivity.this, "Ya validaste esta respuesta ", Toast.LENGTH_SHORT).show();
                        num.setText("");
                        numu.setText("");
                    }
                }
            });
        } else if (clickedCountryName.equals("Multiplicacion")) {
            this.btnGenrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int num1, num2, maximo = 9999, min = 1;
                    num1 = (int) (Math.random() * 100);
                    num2 = (int) (Math.random() * 100);
                    String cad;
                    rmulti = num1 * num2;
                    cad = num1 + "*" + num2;
                    num.setText(cad);
                }
            });
            btnvalidar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    try {
                        int RsultadoU = Integer.parseInt(numu.getText().toString());
                        if (RsultadoU == rmulti) {
                            va.setImageDrawable(getDrawable(R.drawable.ic_action_bien));
                            multiplicacion++;
                            mu.setText(String.valueOf(multiplicacion));
                            num.setText("");
                            numu.setText("");
                        } else {
                            va.setImageDrawable(getDrawable(R.drawable.ic_action_error));
                            multiplicacionm++;
                            mm.setText(String.valueOf(multiplicacionm));
                            num.setText("");
                            numu.setText("");
                        }

                    } catch (Exception e) {
                        Toast.makeText(GameActivity.this, "Ya validaste esta respuesta ", Toast.LENGTH_SHORT).show();
                        num.setText("");
                        numu.setText("");
                    }
                }
            });

        } else if (clickedCountryName.equals("Divicion")) {
            this.btnGenrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int num1, num2, maximo = 9999, min = 1;
                    num1 = (int) (Math.random() * 100);
                    num2 = (int) (Math.random() * 100);
                    String cad;
                    rdivicion = num1 / num2;
                    cad = num1 + "/" + num2;
                    num.setText(cad);
                }
            });
            btnvalidar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        int RsultadoU = Integer.parseInt(numu.getText().toString());
                        if (RsultadoU == rdivicion) {
                            va.setImageDrawable(getDrawable(R.drawable.ic_action_bien));
                            divicion++;

                            di.setText(String.valueOf(divicion));
                            num.setText("");
                            numu.setText("");
                        } else {
                            va.setImageDrawable(getDrawable(R.drawable.ic_action_error));
                            divicionm++;
                            dm.setText(String.valueOf(divicionm));
                            num.setText("");
                            numu.setText("");
                        }
                    } catch (Exception e) {
                        Toast.makeText(GameActivity.this, "Ya validaste esta respuesta ", Toast.LENGTH_SHORT).show();
                        num.setText("");
                        numu.setText("");
                    }
                }
            });
        }
    }

    private void initList() {
        mList = new ArrayList<>();
        mList.add(new Datos("Eliga una opcion"));
        mList.add(new Datos("Suma"));
        mList.add(new Datos("Resta"));
        mList.add(new Datos("Multiplicacion"));
        mList.add(new Datos("Divicion"));

    }
}
