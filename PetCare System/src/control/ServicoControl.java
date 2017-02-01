/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import model.dao.ServicoDao;
import model.domain.Servico;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author Constancio
 */
public class ServicoControl{
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    
    private Servico servicoDigitado;
    
    private Servico servicoSelecionado;
    
    private List<Servico> servicosTabela;
    
    private final ServicoDao servicoDao;
    
    public ServicoControl(){
        servicoDao = new ServicoDao();
        servicosTabela = ObservableCollections.observableList( new ArrayList<Servico>() );
        novo();
        pesquisar();
    }
    
    public void pesquisar(){
        servicosTabela.clear();
        servicosTabela.addAll(servicoDao.pesquisar(servicoDigitado));
    }
    
    public void salvar(){
        servicoDao.salvarAtualizar( servicoDigitado );
        novo();
        pesquisar();
    }
    
    public void excluir(){
        servicoDao.excluir( servicoSelecionado );
        novo();
        pesquisar();
    }
    
    public void novo(){
         setServicoDigitado( new Servico() );
    }

    public Servico getServicoDigitado(){
        return servicoDigitado;
    }

    public void setServicoDigitado( Servico servicoDigitado ){
        Servico oldServicoDigitado = this.servicoDigitado;
        this.servicoDigitado = servicoDigitado;
        propertyChangeSupport.firePropertyChange( "servicoDigitado", oldServicoDigitado, servicoDigitado);
    }

    public Servico getServicoSelecionado(){
        return servicoSelecionado;
    }

    public void setServicoSelecionado( Servico servicoSelecionado ){
        this.servicoSelecionado = servicoSelecionado;
        if( this.servicoSelecionado != null ){
            setServicoDigitado(servicoSelecionado);
        }
    }

    public List<Servico> getServicosTabela(){
        return servicosTabela;
    }
    
    /*
     * Se a servicoSelecionado nao for null, entao esta atualizando.
     * Caso esteja vazio, esta salvando
    */
    public int checkAtualizandoOuSalvando(){
        if(servicoSelecionado!=null){
            //System.out.println("\nRaça selecionada NAO é null!");
            return 1;
        }
        else{
            //System.out.println("\nRaça selecionada é null!");
            return 0;
        }
        
      /*  
        if(servicoDigitado.getId()!=null){
            return 1;
        }
        return 0;*/
    }
    
    public void setServicosTabela( List<Servico> servicosTabela ){
        this.servicosTabela = servicosTabela;
    }
 
     public void addPropertyChangeListener(PropertyChangeListener e){
        propertyChangeSupport.addPropertyChangeListener( e );
    }
    
    public void removePropertyChangeListener(PropertyChangeListener e) {
        propertyChangeSupport.removePropertyChangeListener(e);
    }
}
