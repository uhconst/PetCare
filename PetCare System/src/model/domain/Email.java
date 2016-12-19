/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import java.util.Objects;

/**
 *
 * @author Constancio
 */
public class Email{

    private Integer id;
    
    //private Integer id_pessoa;
    private Pessoa pessoa;
    
    private Tipo_Contato tipo_contato;
    
    // MUDAR NA MODELAGEM DE "EMAIL" PARA "ENDERECO_EMAIL"
    private String endereco_email;
    
    private Boolean principal;
    
    public Email(){
        
    }

    public Integer getId(){
        return id;
    }

    public void setId( Integer id ){
        this.id = id;
    }

    public Pessoa getPessoa(){
        return pessoa;
    }

    public void setPessoa( Pessoa pessoa ){
        this.pessoa = pessoa;
    }

    public Tipo_Contato getTipo_contato(){
        return tipo_contato;
    }

    public void setTipo_contato( Tipo_Contato tipo_contato ){
        this.tipo_contato = tipo_contato;
    }

    public String getEndereco_Email(){
        return endereco_email;
    }

    public void setEndereco_Email( String endereco_email ){
        this.endereco_email = endereco_email;
    }

    public Boolean getPrincipal(){
        return principal;
    }

    public void setPrincipal( Boolean principal ){
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
