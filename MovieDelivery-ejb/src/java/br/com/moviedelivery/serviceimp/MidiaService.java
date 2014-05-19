package br.com.moviedelivery.serviceimp;

import br.com.moviedelivery.entidade.Midia;
import br.com.moviedelivery.service.IMidia;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class MidiaService implements IMidia{
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public List<Midia> listar() {
        TypedQuery<Midia> query =
                em.createQuery("select a from Categoria as a",
                Midia.class);
        return query.getResultList();
    }

    @Override
    public String salvar(Midia midia) {
        try {
            
            em.merge(midia);

        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return null;
    }

    @Override
    public String remover(Integer id) {
        try {
            
           em.remove(em.find(Midia.class, id));
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return null;
    }
    
}
