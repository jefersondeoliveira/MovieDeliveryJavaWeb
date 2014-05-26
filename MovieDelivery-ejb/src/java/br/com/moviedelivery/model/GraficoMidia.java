package br.com.moviedelivery.model;

public class GraficoMidia {
    private int ano;
    private String categoria;
    private int duracao;

    public GraficoMidia(int ano, String categoria, int duracao) {
        this.ano = ano;
        this.categoria = categoria;
        this.duracao = duracao;
    }
    
    

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    
    
}
