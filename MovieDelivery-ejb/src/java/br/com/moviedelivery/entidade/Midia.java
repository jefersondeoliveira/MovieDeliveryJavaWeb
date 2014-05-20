package br.com.moviedelivery.entidade;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Midia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMidia", nullable = false)
    private Integer idMidia;
    
    @NotNull(message = "Informe um titulo")
    @Column(name = "tituloMidia", nullable = false)
    private String tituloMidia;
    
    @NotNull(message = "Informe a duração")
    @Column(name = "duracao", nullable = false)
    private Integer duracao;
    
    @NotNull(message = "Informe a quantidade de exemplares")
    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;
    
    @NotNull(message = "Informe a sinopse")
    @Column(name = "sinopse", nullable = false)
    private String sinopse;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCategoria", nullable = false)
    private Categoria categoria;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "MidiaTipoMidia",
       joinColumns = @JoinColumn(name="idMidia"),
       inverseJoinColumns = @JoinColumn(name = "idTipoMidia"))
    private List<TipoMidia> tipoMidias;

    public Integer getIdMidia() {
        return idMidia;
    }

    public void setIdMidia(Integer idMidia) {
        this.idMidia = idMidia;
    }

    public String getTituloMidia() {
        return tituloMidia;
    }

    public void setTituloMidia(String tituloMidia) {
        this.tituloMidia = tituloMidia;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<TipoMidia> getTipoMidias() {
        return tipoMidias;
    }

    public void setTipoMidias(List<TipoMidia> tipoMidias) {
        this.tipoMidias = tipoMidias;
    }

    
    
}
