package com.example.usuario.altaslista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class Activity_Lista extends AppCompatActivity {


    private List<Persona> listaPersonas;
    private ListView lista;
    private ArrayAdapter<Persona> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__lista);

        findViewById(R.id.Volver).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_Lista.this,MainActivity.class);
                startActivity(intent);
            }
        });

        listaPersonas= ArrayPersonas.getInstance().getPersonas();
        lista=(ListView)findViewById(R.id.lista);
        adapter=new ArrayAdapter<Persona> (this, android.R.layout.simple_list_item_2, android.R.id.text1, listaPersonas) {

            @Override
            public View getView(int position,
                                View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                TextView text1 = (TextView) view.findViewById(android.R.id.text1);
                TextView text2 = (TextView) view.findViewById(android.R.id.text2);

                text1.setText(listaPersonas.get(position).getNombre());

                text2.setText( listaPersonas.get(position).getPrimerApellido()+" "+ listaPersonas.get(position).getSegundoApellido());

                return view;
            }

        };
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent2 = new Intent(Activity_Lista.this,Activity_Altas.class);
                intent2.putExtra("editable",false);
                intent2.putExtra("nombrepersona",listaPersonas.get(i).getNombre().toString());
                intent2.putExtra("primerapellido",listaPersonas.get(i).getPrimerApellido().toString());
                intent2.putExtra("segundoapellido",listaPersonas.get(i).getSegundoApellido().toString());
                startActivity(intent2);
                finish();
            }
        });
    }
}
