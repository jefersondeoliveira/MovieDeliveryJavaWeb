package br.com.moviedelivery.entidade;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCategoria", nullable = false)
    private Integer idCategoria;
    
    @NotNull(message = "Informe uma descrição")
    @Column(name = "descricao", nullable = false)
    private String descricao;
    
    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
    private List<Midia> midias;

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
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
