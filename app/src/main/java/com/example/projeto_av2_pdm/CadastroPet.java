package com.example.projeto_av2_pdm;

public class CadastroPet {
    // definição dos atributos
    // o atributo id não existia na versão anterior
    private long id;
    private String nome;

    private int idade;

    private boolean vacinado;

    private char sexo;
    private double peso;

    private float altura;

    // Métodos de acesso (Setters & Getters)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (!nome.isEmpty()) {
            this.nome = nome;
        }
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if(idade >= 0){
            this.idade = idade;
        }
    }

    public boolean getVacinado() {
        return vacinado;
    }

    public void setVacinado(boolean vacinado) {
        this.vacinado = vacinado;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        if(sexo == 'F' || sexo == 'M'){
           this.sexo = sexo;
        }
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if(peso > 0) {
            this.peso = peso;
        }
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        if(altura > 0){
            this.altura = altura;
        }
    }


    // método construtor com definição dos valores padrão
    public CadastroPet() {
        nome = "Nome Pet";
        idade = 0;
        sexo = 'F';
        altura = 0.0f;
        peso = 0.0;
        vacinado = false;
    }

    // método de formatação dos dados para exibição na lista
    public String textoLista() {
        String item;
        item = getNome();
        item += "\nIdade: " + getIdade();
        item += "\tVacinado: " + (getVacinado() ? "Sim" : "Não");
        item += "\tSexo: " + getSexo();
        item += "\nAltura: " + String.format("%.2f", getAltura());
        item += "\tPeso: " + String.format("%.2f", getPeso());
        return item;
    }
}
