package com.example.projeto_av2_pdm;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class CadastroPetDAO {
    // banco
    private SQLiteDatabase database;
    // colunas da tabela
    private String[] columns = {CadastroSQLiteOpenHelper.COLUNA_ID,
            CadastroSQLiteOpenHelper.COLUNA_NOME,
            CadastroSQLiteOpenHelper.COLUNA_IDADE,
            CadastroSQLiteOpenHelper.COLUNA_VACINADO,
            CadastroSQLiteOpenHelper.COLUNA_SEXO,
            CadastroSQLiteOpenHelper.COLUNA_PESO,
            CadastroSQLiteOpenHelper.COLUNA_ALTURA};
    private CadastroSQLiteOpenHelper sqliteOpenHelper;

    // construtor
    public CadastroPetDAO(Context context) {
        sqliteOpenHelper = new CadastroSQLiteOpenHelper(context);
    }

    // abrir conexão
    public void open() throws SQLException {
        database = sqliteOpenHelper.getWritableDatabase();
    }

    // fechar conexão
    public void close() {
        sqliteOpenHelper.close();
    }

    // inclusão
    public void inserir(String nome, int idade, boolean vacinado, char sexo, double peso, float altura) {

        ContentValues values = new ContentValues();
        values.put(CadastroSQLiteOpenHelper.COLUNA_NOME, nome);
        values.put(CadastroSQLiteOpenHelper.COLUNA_IDADE, idade);
        values.put(CadastroSQLiteOpenHelper.COLUNA_VACINADO, vacinado ? 1 : 0);
        values.put(CadastroSQLiteOpenHelper.COLUNA_SEXO, String.valueOf(sexo));
        values.put(CadastroSQLiteOpenHelper.COLUNA_PESO, peso);
        values.put(CadastroSQLiteOpenHelper.COLUNA_ALTURA, altura);

        long insertId = database.insert(CadastroSQLiteOpenHelper.TABELA, null,
                values);
    }

    // alteração
    public void alterar(long id, String nome, int idade, boolean vacinado, char sexo, double peso, float altura) {
        ContentValues values = new ContentValues();
        values.put(CadastroSQLiteOpenHelper.COLUNA_NOME, nome);
        values.put(CadastroSQLiteOpenHelper.COLUNA_IDADE, idade);
        values.put(CadastroSQLiteOpenHelper.COLUNA_VACINADO, vacinado ? 1 : 0);
        values.put(CadastroSQLiteOpenHelper.COLUNA_SEXO, String.valueOf(sexo));
        values.put(CadastroSQLiteOpenHelper.COLUNA_PESO, peso);
        values.put(CadastroSQLiteOpenHelper.COLUNA_ALTURA, altura);

        database.update(CadastroSQLiteOpenHelper.TABELA, values, CadastroSQLiteOpenHelper.COLUNA_ID + "=" + id, null);
    }


    // exclusão
    public void apagar(long id) {

        database.delete(CadastroSQLiteOpenHelper.TABELA, CadastroSQLiteOpenHelper.COLUNA_ID
                + " = " + id, null);
    }

    // método de busca
    public CadastroPet buscar(long id) {
        Cursor cursor = database.query(CadastroSQLiteOpenHelper.TABELA,
                columns, CadastroSQLiteOpenHelper.COLUNA_ID + " = " + id, null,
                null, null, null);
        cursor.moveToFirst();

        CadastroPet pet = new CadastroPet();
        pet.setId(cursor.getLong(0));
        pet.setNome(cursor.getString(1));
        pet.setIdade(cursor.getInt(2));
        pet.setVacinado(cursor.getInt(3) == 1);
        pet.setSexo(cursor.getString(4).charAt(0));
        pet.setPeso(cursor.getDouble(5));
        pet.setAltura(cursor.getFloat(6));
        cursor.close();

        return pet;
    }

    // criação da lista
    public List<CadastroPet> getAll() {
        List<CadastroPet> cadastroPets = new ArrayList<>();
        Cursor cursor = database.query(CadastroSQLiteOpenHelper.TABELA,
                columns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            CadastroPet pet = new CadastroPet();
            pet.setId(cursor.getLong(0));
            pet.setNome(cursor.getString(1));
            pet.setIdade(cursor.getInt(2));
            pet.setVacinado(cursor.getInt(3) == 1);
            pet.setSexo(cursor.getString(4).charAt(0));
            pet.setPeso(cursor.getDouble(5));
            pet.setAltura(cursor.getFloat(6));
            cadastroPets.add(pet);
            cursor.moveToNext();
        }
        cursor.close();
        return cadastroPets;
    }

}
