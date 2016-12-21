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
import model.dao.PessoaDao;
import model.domain.Pessoa;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author Constancio
 */
public class PessoaControl{
        
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    
    private Pessoa pessoaDigitado;
    
    private Pessoa pessoaSelecionado;
    
    private List<Pessoa> pessoasTabela;
    
    private final PessoaDao pessoaDao;
    
    public PessoaControl(){
        pessoaDao = new PessoaDao();
        pessoasTabela = ObservableCollections.observableList( new ArrayList<Pessoa>() );
        novo();
        pesquisar();
    }
    
    public void pesquisar(){
        pessoasTabela.clear();
        pessoasTabela.addAll(pessoaDao.pesquisar(pessoaDigitado));
    }
    
    public void salvar(){
        System.out.println("\nBotao salvar, dendo do control, data: " + pessoaDigitado.getNascimento());
        pessoaDao.salvarAtualizar( pessoaDigitado );
        novo();
        pesquisar();
    }
    
    public void excluir(){
        pessoaDao.excluir( pessoaSelecionado );
        novo();
        pesquisar();
    }
    
    public void novo(){
         setPessoaDigitado( new Pessoa() );
    }

    public Pessoa getPessoaDigitado(){
        return pessoaDigitado;
    }

    public void setPessoaDigitado( Pessoa pessoaDigitado ){
        Pessoa oldPessoaDigitado = this.pessoaDigitado;
        this.pessoaDigitado = pessoaDigitado;
        propertyChangeSupport.firePropertyChange( "pessoaDigitado", oldPessoaDigitado, pessoaDigitado);
    }

    public Pessoa getPessoaSelecionado(){
        return pessoaSelecionado;
    }

    public void setPessoaSelecionado( Pessoa pessoaSelecionado ){
        this.pessoaSelecionado = pessoaSelecionado;
        if( this.pessoaSelecionado != null ){
            setPessoaDigitado(pessoaSelecionado);
        }
    }

    public List<Pessoa> getPessoasTabela(){
        return pessoasTabela;
    }

    public void setPessoasTabela( List<Pessoa> pessoasTabela ){
        this.pessoasTabela = pessoasTabela;
    }
 
     public void addPropertyChangeListener(PropertyChangeListener e){
        propertyChangeSupport.addPropertyChangeListener( e );
    }
    
    public void removePropertyChangeListener(PropertyChangeListener e) {
        propertyChangeSupport.removePropertyChangeListener(e);
    }
}
