package br.com.moviedelivery.entidade;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Categoria implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCategoria", nullable = false)
    private Short idCategoria;
    
    @NotNull(message = "Informe uma descrição")
    @Column(name = "descricao", nullable = false)
    private String descricao;
    
    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
    private List<Midia> midias;

    public Short getIdCategoria() {
        return idCategoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setIdCategoria(Short idCategoria) {
        this.idCategoria = idCategoria;
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
        hash = 83 * hash + Objects.hashCode(this.idCategoria);
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
        final Categoria other = (Categoria) obj;
        if (!Objects.equals(this.idCategoria, other.idCategoria)) {
            return false;
        }
        return true;
    }

    
}
