package com.example.projeto_av2_pdm;
import android.content.Context ;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class CadastroSQLiteOpenHelper extends SQLiteOpenHelper{
    // definição dos atributos
    public static final String TABELA = " Pet ";
    public static final String COLUNA_ID = " id ";
    public static final String COLUNA_NOME = " nome ";
    public static final String COLUNA_IDADE = " idade ";
    public static final String COLUNA_VACINADO = " vacinado ";
    public static final String COLUNA_SEXO = " sexo ";
    public static final String COLUNA_PESO = " peso ";
    public static final String COLUNA_ALTURA = " altura ";



    // nomeia o banco de dados
    private static final String DATABASE_NAME = "pets.db";
    // determina a versão do banco
    private static final int DATABASE_VERSION = 1;
    // prepara a criação da tabela se não existir
    private static final String CRIAR_BANCO = " create table "
            + TABELA + "("
            + COLUNA_ID + " integer primary key autoincrement , "
            + COLUNA_NOME + " text not null , "
            + COLUNA_IDADE + " INTEGER NOT NULL, "
            + COLUNA_VACINADO + " BOOLEAN NOT NULL, "
            + COLUNA_SEXO + " CHAR NOT NULL, "
            + COLUNA_PESO + " DOUBLE NOT NULL, "
            + COLUNA_ALTURA + " FLOAT NOT NULL);";
    // construtor
    public CadastroSQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    // criação do banco
    @Override
    public void onCreate ( SQLiteDatabase database ) {
        database . execSQL ( CRIAR_BANCO );
    }
    // atualização do banco
    @Override
    public void onUpgrade ( SQLiteDatabase db , int oldVersion , int newVersion ) {
        db. execSQL (" DROP TABLE IF EXISTS " + TABELA );
        onCreate (db);
    }

}
