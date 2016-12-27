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
@Table (name="RACA")
public class Raca{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_RACA")
    private Integer id;
    
    @Column(name="RACA")//,length=45,nullable=false)
    private String raca;

    public Integer getId(){
        return id;
    }

    public void setId( Integer id ){
        this.id = id;
    }

    public String getRaca(){
        return raca;
    }

    public void setRaca( String raca ){
        this.raca = raca;
    }

    @Override
    public int hashCode(){
        int hash = 3;
        hash = 83 * hash + Objects.hashCode( this.id );
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
        final Raca other = (Raca) obj;
        if( !Objects.equals( this.id, other.id ) ){
            return false;
        }
        return true;
    }
    
    
}
