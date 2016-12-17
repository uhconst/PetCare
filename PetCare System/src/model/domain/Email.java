/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

/**
 *
 * @author Constancio
 */
public class Email{

    private Integer id;
    
    //private Integer id_pessoa;
    private Pessoa pessoa;
    
    private Tipo_Contato tipo_contato;
    
    private String email;
    
    private Boolean principal;
    
    public Email(){
        
    }
    
}
