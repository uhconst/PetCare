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
import model.dao.EmailDao;
import model.domain.Email;
import model.domain.Pessoa;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author Constancio
 */
public class EmailControl{
            
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    
    private Email emailDigitado;
    
    private Email emailSelecionado;
    
    private List<Email> emailsTabela;
    
    private final EmailDao emailDao;
    
    public EmailControl(){
        emailDao = new EmailDao();
        emailsTabela = ObservableCollections.observableList( new ArrayList<Email>() );
        novo();
        pesquisar();
    }
    
    public void pesquisar(){
        emailsTabela.clear();
        emailsTabela.addAll(emailDao.pesquisar(emailDigitado));
    }
    
    public void salvar(){
        emailDao.salvarAtualizar( emailDigitado );
        novo();
        pesquisar();
    }
    
    public void excluir(Email email){
        emailDao.excluir( email );
        //novo();
        //pesquisar();
    }
    
    public void novo(){
         setEmailDigitado( new Email() );
    }

    public Email getEmailDigitado(){
        return emailDigitado;
    }

    public void setEmailDigitado( Email emailDigitado ){
        Email oldEmailDigitado = this.emailDigitado;
        this.emailDigitado = emailDigitado;
        //System.out.println("\n******Email digitado: " + this.emailDigitado.getEndereco_email() +"****");
        propertyChangeSupport.firePropertyChange( "emailDigitado", oldEmailDigitado, emailDigitado);
    }

    public Email getEmailSelecionado(){
        return emailSelecionado;
    }

    public void setEmailSelecionado( Email emailSelecionado ){
        this.emailSelecionado = emailSelecionado;
        if( this.emailSelecionado != null ){
            setEmailDigitado(emailSelecionado);
        }
    }

    public List<Email> getEmailsTabela(){
        return emailsTabela;
    }

    public void setEmailsTabela( List<Email> emailsTabela ){
        this.emailsTabela = emailsTabela;
    }
    
    // Setando a pessoa que foi digitada e salva
    public void setPessoaDigitada( Pessoa pessoaDigitada ){
        //System.out.println("\n******Email digitado na pessoaDigitada: " + emailDigitado.getPessoa().getEmail().getEndereco_email() +"****");
        emailDigitado.setPessoa( pessoaDigitada );
    }
/*    
    public void setPrincipal( Boolean principal ){
        if(principal){
            emailDigitado.setPrincipal( "S" );
        }
        else{
            emailDigitado.setPrincipal( "N" );
        }
    }
       */ 
     public void addPropertyChangeListener(PropertyChangeListener e){
        propertyChangeSupport.addPropertyChangeListener( e );
    }
    
    public void removePropertyChangeListener(PropertyChangeListener e) {
        propertyChangeSupport.removePropertyChangeListener(e);
    }

}
