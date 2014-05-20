package br.com.moviedelivery.controller;

import br.com.moviedelivery.entidade.TipoMidia;
import br.com.moviedelivery.service.ITipoMidiaService;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named("tipoMidiaManagedBean")
@RequestScoped
public class TipoMidiaManagedBean {
    
    private TipoMidia tipoMidia;
    private TipoMidia tipoMidiaSelecionado;
    
    @EJB
    private ITipoMidiaService tipoMidiaService;
    
    public List<TipoMidia> listar(){
        return tipoMidiaService.listar();
    }
    
    public TipoMidiaManagedBean(){
        tipoMidia = new TipoMidia();
    }
    
    public void salvar() {
        String erro = tipoMidiaService.salvar(tipoMidia);
        if (erro == null) {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Tipo de midia salvo com sucesso", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    erro, null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
        tipoMidia = new TipoMidia();
    }
    
    public void excluir(){
        String erro = tipoMidiaService.remover(tipoMidiaSelecionado.getIdTipoMidia());
        if (erro == null) {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Tipo de midia excluido com sucesso", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    erro, null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
    }
    
    public void editar(){
        tipoMidia = tipoMidiaSelecionado;
    }

    public TipoMidia getTipoMidia() {
        return tipoMidia;
    }

    public void setTipoMidia(TipoMidia tipoMidia) {
        this.tipoMidia = tipoMidia;
    }

    public TipoMidia getTipoMidiaSelecionado() {
        return tipoMidiaSelecionado;
    }

    public void setTipoMidiaSelecionado(TipoMidia tipoMidiaSelecionado) {
        this.tipoMidiaSelecionado = tipoMidiaSelecionado;
    }

    
}
