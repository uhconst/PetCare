/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.domain.Animal;

/**
 *
 * @author Constancio
 */
public class AnimalDao{
    
    public void salvarAtualizar(Animal animal) {
        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();
        if(animal.getId() !=null){
            animal = em.merge(animal);
        }
        em.persist(animal);
        em.getTransaction().commit();
        em.close();
    }
    
    public void excluir(Animal animal) {
        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();
        animal = em.merge(animal);
        em.remove(animal);
        em.getTransaction().commit();
        em.close();
    }
    
    public List<Animal> pesquisar(Animal animal) {
        EntityManager em = Conexao.getEntityManager();
        StringBuilder sql = new StringBuilder("from Animal a "
                + "where 1 = 1 ");
        if (animal.getId() !=null) {
            sql.append("and a.id = :id_animal ");
        }
        if (animal.getNome() !=null &&
                !animal.getNome().equals("")){
            sql.append("and LOWER(a.nome) like '%'||LOWER(:nome)||'%' ");
            
        }
        if (animal.getRaca()!=null){
            sql.append("and a.raca = :raca");
            //sql.append("and a.id_raca = "+animal.getRaca());
            //sql.append( "and a.id_raca = " ).append(Integer.toString(animal.getRaca().getId()));
            //(Integer.toString(animal.getRaca().getId()));
        }
        
        if (animal.getPessoa()!=null){
            sql.append("and a.pessoa = :pessoa");
        }                
        Query query = em.createQuery(sql.toString());
        if (animal.getId() !=null) {
            query.setParameter("id_animal",animal.getId());
        }
        if (animal.getNome() != null &&
                !animal.getNome().equals("")){
            query.setParameter("nome","%"+animal.getNome());
        }
        if (animal.getRaca() != null){
            query.setParameter("raca",(animal.getRaca()));
        }
        if (animal.getPessoa() != null){
            query.setParameter("pessoa",(animal.getPessoa()));
        }
        /*
        if (animal.getRaca() != null){
            query.setParameter("id_raca",animal.getRaca());
        }*/
                
        return query.getResultList();
    }
    
}
