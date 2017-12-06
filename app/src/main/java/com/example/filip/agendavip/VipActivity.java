package com.example.filip.agendavip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class VipActivity extends AppCompatActivity {

    List<Contato> listaDeContatos = RepositorioContatos.getContatos();
    AdapterVip adapter = new AdapterVip(listaDeContatos, this);
    ListView lvContatos;
    Button agenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vip);

        agenda = (Button)  findViewById(R.id.btnAgenda);
        lvContatos = (ListView) findViewById(R.id.lvVips);
        lvContatos.setAdapter(adapter);

        agenda.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intencaoReturn = new Intent(VipActivity.this, MainActivity.class);
                VipActivity.this.startActivity(intencaoReturn);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

}
