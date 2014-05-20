package br.com.moviedelivery.serviceimp;

import br.com.moviedelivery.entidade.Categoria;
import br.com.moviedelivery.service.ICategoriaService;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class CategoriaService implements ICategoriaService{
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public List<Categoria> listar() {
        TypedQuery<Categoria> query =
                em.createQuery("select a from Categoria as a",
                Categoria.class);
        return query.getResultList();
    }

    @Override
    public String salvar(Categoria categoria) {
        try {
            
            em.merge(categoria);

        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return null;
    }

    @Override
    public String remover(Integer id) {
        try {
            
           em.remove(em.find(Categoria.class, id));
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return null;
    }
    
}
