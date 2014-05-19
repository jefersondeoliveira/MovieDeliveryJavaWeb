package br.com.moviedelivery.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class TipoMidia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoMidia", nullable = false)
    private Integer idTipoMidia;
    
    @NotNull(message = "Informe uma descrição")
    @Column(name = "descricao", nullable = false)
    private String descricao;

    public Integer getIdTipoMidia() {
        return idTipoMidia;
    }

    public void setIdTipoMidia(Integer idTipoMidia) {
        this.idTipoMidia = idTipoMidia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
