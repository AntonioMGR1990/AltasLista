package com.example.usuario.altaslista;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_Altas extends AppCompatActivity {

    private EditText nombre;
    private EditText Papellido;
    private EditText Sapellido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__altas);
        nombre = findViewById(R.id.NombreEditText);
        Papellido = findViewById(R.id.PAEditText2);
        Sapellido = findViewById(R.id.SAEditText3);
        if(getIntent()!=null && getIntent().hasExtra("editable")){
            nombre.setEnabled(false);
            Papellido.setEnabled(false);
            Sapellido.setEnabled(false);
            nombre.setText(getIntent().getStringExtra("nombrepersona"));
            Papellido.setText(getIntent().getStringExtra("primerapellido"));
            Sapellido.setText(getIntent().getStringExtra("segundoapellido"));
            findViewById(R.id.Enviarbtn).setVisibility(View.INVISIBLE);
        }

        findViewById(R.id.Volverbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_Altas.this,MainActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.Enviarbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(Activity_Altas.this);
                alert.setMessage("¿Son correctos estos datos?");
                alert.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    String nombre1 = nombre.getText().toString();
                    String apellido1 = Papellido.getText().toString();
                    String apellido2 = Sapellido.getText().toString();

                    ArrayPersonas.getInstance().add(new Persona(nombre1,apellido1,apellido2));

                    finish();

                    }
                });
                alert.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                    }
                });
                alert.setCancelable(false);
                alert.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        Toast.makeText(Activity_Altas.this,"pulsa dentro del dialogo",Toast.LENGTH_SHORT).show();
                    }
                });
                alert.show();
            }
        });

    }
}
