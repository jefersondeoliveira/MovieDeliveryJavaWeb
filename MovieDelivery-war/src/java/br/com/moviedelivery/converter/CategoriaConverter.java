package br.com.moviedelivery.converter;

import br.com.moviedelivery.entidade.Categoria;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "categoriaConverter", forClass = Categoria.class)
public class CategoriaConverter implements Converter{
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            if(value == null || value.isEmpty()){
                return null;
            }
            Integer id = Integer.parseInt(value);
            Categoria categoria = new Categoria();
            categoria.setIdCategoria(id);
            return categoria;
            
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        
        if(value == null || value.getClass() != Categoria.class){
            return null;
        }
        
        Categoria categoria  = (Categoria) value;
        
        return categoria.getIdCategoria().toString();
        
    }
}
