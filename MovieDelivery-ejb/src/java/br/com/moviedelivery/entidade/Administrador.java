package br.com.moviedelivery.entidade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Administrador extends Pessoa{
    
    @NotNull(message = "Informe um email")
    @Column(name = "email", nullable = false)
    private String email;
    
    @NotNull(message = "Informe uma senha")
    @Column(name = "senha", nullable = false)
    private String senha;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
}
