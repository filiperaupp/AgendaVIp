package com.example.filip.agendavip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class CadastroActivity extends AppCompatActivity {
    EditText edNome;
    EditText edTelefone;
    Button btnCadastrar;
    Boolean vipOrNot = false;
    RadioGroup grupoRadio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        grupoRadio = (RadioGroup) findViewById(R.id.rgVip);
        edNome = (EditText) findViewById(R.id.edNome);
        edTelefone = (EditText) findViewById(R.id.edTelefone);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                RepositorioContatos.getContatos().add(getContato());
                CadastroActivity.this.finish();
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        if (grupoRadio.getCheckedRadioButtonId() == -1)
        {
            vipOrNot = false;
        }
        else
        {
            switch(view.getId()) {
                case R.id.rbSim:
                    if (checked) {
                        vipOrNot = true;
                    }
                    break;
                case R.id.rbNao:
                    if (checked) {
                        vipOrNot = false;
                    }
                    break;

            }
        }

    }

    private Contato getContato(){
        Contato contato = new Contato();
        contato.setNome(edNome.getText().toString());
        contato.setTelefone(edTelefone.getText().toString());
        contato.setVip(vipOrNot);
        return contato;
    }
}
