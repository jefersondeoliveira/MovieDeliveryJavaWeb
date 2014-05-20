package br.com.moviedelivery.serviceimp;

import br.com.moviedelivery.entidade.Administrador;
import br.com.moviedelivery.service.IAdministradorService;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class AdministradorService implements IAdministradorService{
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public List<Administrador> listar() {
        TypedQuery<Administrador> query =
                em.createQuery("select a from Administrador as a",
                Administrador.class);
        return query.getResultList();
    }

    @Override
    public String salvar(Administrador administrador) {
        try {
            
            em.merge(administrador);

        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return null;
    }

    @Override
    public String remover(Integer id) {
        try {
            
           em.remove(em.find(Administrador.class, id));
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return null;
    }
    
}
