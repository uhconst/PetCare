/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Constancio
 */
/*
@Entity
@Table (name="EMAIL")*/
public class Email{
    
/*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_EMAIL")*/
    private Integer id;
   
    /*@JoinColumn(name = "ID_PESSOA")
    @ManyToOne
    private Pessoa pessoa;*/
    /*@OneToMany
    @JoinTable(name="EMAIL_PESSOA", joinColumns=@JoinColumn(name="EMAIL_ID"), 
                inverseJoinColumns=@JoinColumn(name="PESSOA_ID"))*/
    private Collection<Pessoa> pessoa = new ArrayList<Pessoa>();
  /*
    @OneToMany
    @JoinColumn(name = "ID_TIPO_CONTATO")*/
    private Tipo_Contato tipo_contato;
    
    // MUDAR NA MODELAGEM DE "EMAIL" PARA "ENDERECO_EMAIL"
    //@Column(name="ENDERECO_EMAIL")
    private String endereco_email;
    
    //@Column(name="PRINCIPAL")
    private String principal;
    
    public Email(){
        System.out.println("Dentro do construtor do email!!!");
    }

    public Integer getId(){
        return id;
    }

    public void setId( Integer id ){
        this.id = id;
    }
/*
    public Pessoa getPessoa(){
        return pessoa;
    }

    public void setPessoa( Pessoa pessoa ){
        this.pessoa = pessoa;
    }
*/      
    
    public Tipo_Contato getTipo_contato(){
        return tipo_contato;
    }

    public void setTipo_contato( Tipo_Contato tipo_contato ){
        this.tipo_contato = tipo_contato;
    }

    public String getEndereco_email(){
        return endereco_email;
    }

    public void setEndereco_email( String endereco_email ){
        this.endereco_email = endereco_email;
    }

    public String getPrincipal(){
        return principal;
    }

    public void setPrincipal( String principal ){
        this.principal = principal;
    }

    
    @Override
    public int hashCode(){
        int hash = 5;
        hash = 71 * hash + Objects.hashCode( this.id );
        return hash;
    }

    @Override
    public boolean equals( Object obj ){
        if( this == obj ){
            return true;
        }
        if( obj == null ){
            return false;
        }
        if( getClass() != obj.getClass() ){
            return false;
        }
        final Email other = (Email) obj;
        if( !Objects.equals( this.id, other.id ) ){
            return false;
        }
        return true;
    }
    
    
}
