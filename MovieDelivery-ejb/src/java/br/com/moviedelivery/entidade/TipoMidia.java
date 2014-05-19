package br.com.moviedelivery.entidade;

import javax.persistence.*;
import java.util.List;
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
    
    @OneToMany(mappedBy = "tipoMidia", fetch = FetchType.LAZY)
    private List<Midia> midias;

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

    public List<Midia> getMidias() {
        return midias;
    }

    public void setMidias(List<Midia> midias) {
        this.midias = midias;
    }

   
}
