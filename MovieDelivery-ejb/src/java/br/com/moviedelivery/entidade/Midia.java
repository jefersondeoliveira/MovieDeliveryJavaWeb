package br.com.moviedelivery.entidade;

import java.util.List;
import java.util.Objects;
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
    
    @NotNull(message = "Informe a ano")
    @Column(name = "ano", nullable = false)
    private Integer ano;
    
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

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }
    
    

}
