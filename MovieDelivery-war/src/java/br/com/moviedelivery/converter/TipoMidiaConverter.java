package br.com.moviedelivery.converter;

import br.com.moviedelivery.entidade.TipoMidia;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "tipoMidiaConverter", forClass = TipoMidia.class)
public class TipoMidiaConverter implements Converter{
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            if(value == null || value.isEmpty()){
                return null;
            }
            Short id = Short.parseShort(value);
            TipoMidia tipoMidia = new TipoMidia();
            tipoMidia.setIdTipoMidia(id);
            return tipoMidia;
            
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        
        if(value == null || value.getClass() != TipoMidia.class){
            return null;
        }
        
        TipoMidia tipoMidia  = (TipoMidia) value;
        
        return tipoMidia.getIdTipoMidia().toString();
        
    }
}
