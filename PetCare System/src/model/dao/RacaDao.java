/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.domain.Raca;

/**
 *
 * @author Constancio
 */
public class RacaDao{
    public void salvarAtualizar(Raca raca) {
        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();
        if(raca.getId() !=null){
            raca = em.merge(raca);
        }
        em.persist(raca);
        em.getTransaction().commit();
        em.close();
    }
    
    public void excluir(Raca raca) {
        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();
        raca = em.merge(raca);
        em.remove(raca);
        em.getTransaction().commit();
        em.close();
    }
    
    public List<Raca> pesquisar(Raca raca) {
        EntityManager em = Conexao.getEntityManager();
        StringBuilder sql = new StringBuilder("from Raca r "
                + "where 1 = 1 ");
        if (raca.getId() !=null) {
            sql.append("and r.id = :id_raca ");
        }
        if (raca.getRaca() !=null &&
                !raca.getRaca().equals("")){
            sql.append("and LOWER(r.raca) like '%'||LOWER(:raca)||'%'");
            
        }
        Query query = em.createQuery(sql.toString());
        if (raca.getId() !=null) {
            query.setParameter("id_raca",raca.getId());
            
        }
        if (raca.getRaca() != null &&
                !raca.getRaca().equals("")){
            query.setParameter("raca","%"+raca.getRaca());
        }
        return query.getResultList();
    }
    
}
