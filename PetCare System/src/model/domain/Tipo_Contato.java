/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Constancio
 */
@Entity
@Table (name="TIPO_CONTATO")
public class Tipo_Contato{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_TIPO_CONTATO")
    private Integer id;
    
    @Column(name="TIPO")
    private String tipo;
    // REMOVI A SIGLA, REMOVER NA MODELAGEM
    
    public Tipo_Contato(){
    
    }

    public Integer getId(){
        return id;
    }

    public void setId( Integer id ){
        this.id = id;
    }

    public String getTipo(){
        return tipo;
    }

    public void setTipo( String tipo ){
        this.tipo = tipo;
    }

    @Override
    public int hashCode(){
        int hash = 7;
        hash = 59 * hash + Objects.hashCode( this.id );
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
        final Tipo_Contato other = (Tipo_Contato) obj;
        if( !Objects.equals( this.id, other.id ) ){
            return false;
        }
        return true;
    }
    
    
    
}
