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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Constancio
 */
@Entity
@Table (name="ANIMAL")
public class Animal{
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_ANIMAL")
    private Integer id;
    
    @OneToOne
    @JoinColumn(name = "ID_RACA")
    private Raca raca;
    
    @Column(name="NOME")
    private String nome;
    
    @Column(name="SEXO")
    private String sexo;

    public Integer getId(){
        return id;
    }

    public void setId( Integer id ){
        this.id = id;
    }

    public Raca getRaca(){
        return raca;
    }

    public void setRaca( Raca raca ){
        this.raca = raca;
    }

    public String getNome(){
        return nome;
    }

    public void setNome( String nome ){
        this.nome = nome;
    }

    public String getSexo(){
        return sexo;
    }

    public void setSexo( String sexo ){
        this.sexo = sexo;
    }

    @Override
    public int hashCode(){
        int hash = 7;
        hash = 89 * hash + Objects.hashCode( this.id );
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
        final Animal other = (Animal) obj;
        if( !Objects.equals( this.id, other.id ) ){
            return false;
        }
        return true;
    }
    
    
}
