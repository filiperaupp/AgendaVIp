package com.example.filip.agendavip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnAdicionar;
    ListView lvContatos;
    List<Contato> listaDeContatos = RepositorioContatos.getContatos();
    AdapterContato adapter = new AdapterContato(listaDeContatos, this);
    Button contatosVips;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contatosVips = (Button) findViewById(R.id.btnVip);
        btnAdicionar = (Button) findViewById(R.id.btnAdd);
        lvContatos = (ListView) findViewById(R.id.lvContatos);
        lvContatos.setAdapter(adapter);

        btnAdicionar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intencao = new Intent(MainActivity.this, CadastroActivity.class);
                MainActivity.this.startActivity(intencao);
            }
        });

        contatosVips.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intencaoVip = new Intent(MainActivity.this, VipActivity.class);
                MainActivity.this.startActivity(intencaoVip);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }
}
