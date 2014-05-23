package br.com.moviedelivery.model;

public class GraficoTipoDeMidia {
    private String categoria;
    private String tipoMidia;
    private int quantidade;

    public GraficoTipoDeMidia(String categoria, String tipoMidia, int quantidade) {
        this.categoria = categoria;
        this.tipoMidia = tipoMidia;
        this.quantidade = quantidade;
    }
    
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipoMidia() {
        return tipoMidia;
    }

    public void setTipoMidia(String tipoMidia) {
        this.tipoMidia = tipoMidia;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
}
