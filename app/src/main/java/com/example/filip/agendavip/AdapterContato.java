package com.example.filip.agendavip;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by filip on 05/12/2017.
 */

public class AdapterContato extends BaseAdapter {
    List<Contato> contatos;
    Context context;

    public AdapterContato(List<Contato> contatos, Context context) {
        this.contatos = contatos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return contatos.size();
    }

    @Override
    public Object getItem(int position) {
        return contatos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View resultView = LayoutInflater.from(context).inflate(R.layout.item_contato, parent, false);
        TextView tvNome = resultView.findViewById(R.id.tvNome);
        TextView tvTelefone = resultView.findViewById(R.id.tvTelefone);
        TextView tvVip = resultView.findViewById(R.id.tvVip);

        Contato contato = contatos.get(position);
        tvNome.setText(contato.getNome());
        tvTelefone.setText(contato.getTelefone());
        if (contato.getVip()) {
            tvVip.setText("VIP");
        }
        else {
            tvVip.setText("Comum");
        }
        return resultView;
    }
}
