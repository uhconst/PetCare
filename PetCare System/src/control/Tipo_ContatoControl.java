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
import model.dao.Tipo_ContatoDao;
import model.domain.Tipo_Contato;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author Constancio
 */
public class Tipo_ContatoControl{
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    
    private Tipo_Contato tipo_contatoDigitado;
    
    private Tipo_Contato tipo_contatoSelecionado;
    
    private List<Tipo_Contato> tipo_contatosTabela;
    
    private final Tipo_ContatoDao tipo_contatoDao;
    
    public Tipo_ContatoControl(){
        tipo_contatoDao = new Tipo_ContatoDao();
        tipo_contatosTabela = ObservableCollections.observableList( new ArrayList<Tipo_Contato>() );
        novo();
        pesquisar();
    }
    
    public void pesquisar(){
        tipo_contatosTabela.clear();
        tipo_contatosTabela.addAll(tipo_contatoDao.pesquisar(tipo_contatoDigitado));
    }
    
    public void salvar(){
        /*System.out.println("Nome digitado: " + tipo_contatoDigitado.getNome() + 
                            "\nTelefone digitado: " + tipo_contatoDigitado.getTelefone());*/
        tipo_contatoDao.salvarAtualizar( tipo_contatoDigitado );
        novo();
        pesquisar();
    }
    
    public void excluir(){
        tipo_contatoDao.excluir( tipo_contatoSelecionado );
        novo();
        pesquisar();
    }
    
    public void novo(){
         setTipo_ContatoDigitado( new Tipo_Contato() );
    }

    public Tipo_Contato getTipo_ContatoDigitado(){
        return tipo_contatoDigitado;
    }

    public void setTipo_ContatoDigitado( Tipo_Contato tipo_contatoDigitado ){
        Tipo_Contato oldTipo_ContatoDigitado = this.tipo_contatoDigitado;
        this.tipo_contatoDigitado = tipo_contatoDigitado;
        propertyChangeSupport.firePropertyChange( "tipo_contatoDigitado", oldTipo_ContatoDigitado, tipo_contatoDigitado);
    }

    public Tipo_Contato getTipo_ContatoSelecionado(){
        return tipo_contatoSelecionado;
    }

    public void setTipo_ContatoSelecionado( Tipo_Contato tipo_contatoSelecionado ){
        this.tipo_contatoSelecionado = tipo_contatoSelecionado;
        if( this.tipo_contatoSelecionado != null ){
            setTipo_ContatoDigitado(tipo_contatoSelecionado);
        }
    }

    public List<Tipo_Contato> getTipo_ContatosTabela(){
        return tipo_contatosTabela;
    }

    public void setTipo_ContatosTabela( List<Tipo_Contato> tipo_contatosTabela ){
        this.tipo_contatosTabela = tipo_contatosTabela;
    }
 
     public void addPropertyChangeListener(PropertyChangeListener e){
        propertyChangeSupport.addPropertyChangeListener( e );
    }
    
    public void removePropertyChangeListener(PropertyChangeListener e) {
        propertyChangeSupport.removePropertyChangeListener(e);
    }
}
