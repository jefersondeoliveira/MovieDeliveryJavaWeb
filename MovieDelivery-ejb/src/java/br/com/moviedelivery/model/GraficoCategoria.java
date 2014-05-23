package br.com.moviedelivery.model;

public class GraficoCategoria {
    private String categoria;
    private int quantidade;

    public GraficoCategoria(String categoria, int quantidade) {
        this.categoria = categoria;
        this.quantidade = quantidade;
    }
    
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
    
}
