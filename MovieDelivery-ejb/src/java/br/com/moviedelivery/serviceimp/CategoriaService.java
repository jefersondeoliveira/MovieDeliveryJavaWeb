package br.com.moviedelivery.serviceimp;

import br.com.moviedelivery.entidade.Categoria;
import br.com.moviedelivery.model.GraficoCategoria;
import br.com.moviedelivery.service.ICategoriaService;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintViolationException;

@Stateless
public class CategoriaService implements ICategoriaService{
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public List<Categoria> listar() {
        TypedQuery<Categoria> query =
                em.createQuery("select c from Categoria as c",
                Categoria.class);
        return query.getResultList();
    }

    @Override
    public String salvar(Categoria categoria) {
        try {
            
            em.merge(categoria);
            
        } catch (ConstraintViolationException ex) {
            ex.getConstraintViolations();
            return ex.getMessage();
        }

        return null;
    }

    @Override
    public String remover(Short id) {
        try {
            
           em.remove(em.find(Categoria.class, id));
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return null;
    }

    @Override
    public List<GraficoCategoria> gerarGrafico() {
        TypedQuery<GraficoCategoria> query 
               = em.createQuery("select new br.com.moviedelivery.model.GraficoCategoria"
                + "( c.descricao, SIZE(c.midias)) from Categoria as c ", 
                GraficoCategoria.class);
        
        return query.getResultList();
    }
    
}
