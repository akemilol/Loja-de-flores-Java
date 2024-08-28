package models;

import enums.TipoFlor;

public class Flor {

    private int codigo;
    private String nome;
    private TipoFlor tipo;
    private double preco;

    public Flor(int codigo, String nome, TipoFlor tipo, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoFlor getTipo() {
        return tipo;
    }

    public void setTipo(TipoFlor tipo) {
        this.tipo = tipo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Flor{" +
                "codigo=" + codigo +
                ", nome=" + nome + ", " +
                "tipo=" + tipo +
                '}';
    }
}


