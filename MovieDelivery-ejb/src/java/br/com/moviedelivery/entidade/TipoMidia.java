package br.com.moviedelivery.entidade;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import javax.validation.constraints.NotNull;

@Entity
public class TipoMidia implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoMidia", nullable = false)
    private Short idTipoMidia;
    
    @NotNull(message = "Informe uma descrição")
    @Column(name = "descricao", nullable = false)
    private String descricao;
    
    @ManyToMany(mappedBy = "tipoMidias", fetch = FetchType.LAZY)
    private List<Midia> midias;

    public Short getIdTipoMidia() {
        return idTipoMidia;
    }

    public void setIdTipoMidia(Short idTipoMidia) {
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.idTipoMidia);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipoMidia other = (TipoMidia) obj;
        if (!Objects.equals(this.idTipoMidia, other.idTipoMidia)) {
            return false;
        }
        return true;
    }

    
   
}
