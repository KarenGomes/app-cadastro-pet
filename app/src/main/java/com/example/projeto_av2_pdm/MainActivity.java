package com.example.projeto_av2_pdm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lista;
    Intent intent;
    public static final int ACTIVITY_REQUEST_CADASTRO = 1;
    private CadastroPetDAO dao;

    private String[] cadastroPets;
    private long[] idPets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = (ListView) findViewById(R.id.lista);
        setTitle("Banco de Dados com SQLite!");
        dao = new CadastroPetDAO(this);
        dao.open();

        lista.setOnItemClickListener(this); // Clique no item
    }

    @Override
    protected void onResume() {
        dao.open();
        super.onResume();
        List<CadastroPet> listaPets = dao.getAll();
        cadastroPets = new String[listaPets.size()];
        idPets = new long[listaPets.size()];
        int i = 0;
        Iterator<CadastroPet> iterator = listaPets.iterator();
        while (iterator.hasNext()) {
            CadastroPet aux = new CadastroPet();
            aux = (CadastroPet) iterator.next();
            cadastroPets[i] = aux.textoLista();
            idPets[i] = aux.getId();
            i++;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, cadastroPets);
        lista.setAdapter(adapter);
    }


    @Override
    protected void onPause() {
        dao.close();
        super.onPause();
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long ident) {
        long id = idPets[position];
        intent = new Intent(getApplicationContext(), ActivityTratarCadastroPet.class);
        intent.putExtra("acao", 0);
        intent.putExtra("id", id);
        startActivity(intent);
    }


    public void IncluirPet(View v) {
        intent = new Intent(getApplicationContext(), ActivityTratarCadastroPet.class);
        intent.putExtra("acao", -1);
        intent.putExtra("id", 0L);
        startActivity(intent);
    }

    public void sair(View v) {
        finish();

    }

}