package com.example.projeto_av2_pdm;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.RadioButton;

public class ActivityTratarCadastroPet extends AppCompatActivity {
    EditText edtNome, edtIdade, edtPeso, edtAltura;
    Button bt1, bt2;
    RadioButton btnSim, btnNao, btnFem, btnMasc;
    private int acao;
    private long id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tratar_cadastro_pet);

        bt1 = (Button) findViewById(R.id.button);
        bt2 = (Button) findViewById(R.id.button2);
        edtNome = (EditText) findViewById(R.id.editText);
        edtIdade = (EditText) findViewById(R.id.editText2);
        edtPeso = (EditText) findViewById(R.id.editText3);
        edtAltura = (EditText) findViewById(R.id.editText4);

        btnSim = (RadioButton) findViewById(R.id.sim);
        btnNao = (RadioButton) findViewById(R.id.nao);
        btnFem = (RadioButton) findViewById(R.id.radioButton4);
        btnMasc = (RadioButton) findViewById(R.id.radioButton3);

        acao = getIntent().getExtras().getInt("acao");
        id = getIntent().getExtras().getLong("id");

        if (acao == -1) {
            // inclusão
            setTitle("Inserir Pet");
            bt1.setText("Incluir");
            bt2.setEnabled(false);
            edtNome.setText("Nome Pet");
            edtIdade.setText("0");
            edtPeso.setText(String.format("%.1f", 0.0));
            edtAltura.setText(String.format("%.1f", 0.0));
        } else {
            // alteração ou exclusão
            setTitle("Alterar ou Excluir Pet");
            CadastroPet aux = new CadastroPet();
            CadastroPetDAO dao = new CadastroPetDAO(this);
            dao.open();
            aux = dao.buscar(id);
            edtNome.setText(aux.getNome());
            edtIdade.setText(String.valueOf(aux.getIdade()));
            edtPeso.setText(String.format("%.1f", aux.getPeso()));
            edtAltura.setText(String.format("%.1f", aux.getAltura()));
            if (aux.getVacinado()) {
                btnSim.setChecked(true);
            } else {
                btnNao.setChecked(true);
            }
            if (aux.getSexo() == 'F') {
                btnFem.setChecked(true);
            } else {
                btnMasc.setChecked(true);
            }
            dao.close();
        }
    }

    public void alterarInserir(View v) {
        String nome;
        int idade;
        float altura;
        double peso;
        char sexo;
        boolean vacinado;

        nome = edtNome.getText().toString();
        idade = Integer.parseInt(edtIdade.getText().toString());
        peso = Double.parseDouble(edtPeso.getText().toString());
        altura = Float.parseFloat(edtAltura.getText().toString());
        sexo = verificaSexo();
        vacinado = verificaVacinado();

        CadastroPetDAO dao = new CadastroPetDAO(this);
        dao.open();
        if (acao == -1) { // inserção
            dao.inserir(nome, idade, vacinado, sexo, peso, altura);
        } else { // alteração
            dao.alterar(id, nome, idade, vacinado, sexo, peso, altura);
        }
        dao.close();
        finish();
    }

    public char verificaSexo(){
        if(btnFem.isChecked()){
            return 'F';
        }else {
            return 'M';
        }
    }

    public boolean verificaVacinado(){
        if(btnSim.isChecked()){
            return true;
        }else {
            return false;
        }
    }

    public void excluir(View v) {
        // exclusão
        if (acao == 0) {
            CadastroPetDAO dao = new CadastroPetDAO(this);
            dao.open();
            dao.apagar(id);
            dao.close();
        }
        finish();
    }

    public void voltar(View v) {
        finish();
    }
}