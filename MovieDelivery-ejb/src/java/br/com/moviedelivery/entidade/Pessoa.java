package br.com.moviedelivery.entidade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public  class Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPessoa", nullable = false)
    private Integer idPessoa;
    
    @NotNull(message = "Informe um nome")
    @Column(name = "nome", nullable = false)
    private String nome;
    
    @OneToOne(mappedBy = "pessoa", fetch = FetchType.LAZY)
    private Administrador administrador;    

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
    
    
}
