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
public class Telefone{
    
    private Integer id;
    
    //private Integer id_pessoa;
    private Pessoa pessoa;
    
    private Tipo_Contato tipo_contato;
    
    // Na modelagem ta telefone, mudar lá
    private String numero;
    
    private String categoria;
    
    private Boolean principal;
    
    public Telefone(){
        
    }
}
