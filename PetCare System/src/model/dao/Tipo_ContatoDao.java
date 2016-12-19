/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.domain.Tipo_Contato;

/**
 *
 * @author Constancio
 */
public class Tipo_ContatoDao{
    public void salvarAtualizar(Tipo_Contato tipo_contato) {
        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();
        if(tipo_contato.getId() !=null){
            tipo_contato = em.merge(tipo_contato);
        }
        em.persist(tipo_contato);
        em.getTransaction().commit();
        em.close();
    }
    
    public void excluir(Tipo_Contato tipo_contato) {
        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();
        tipo_contato = em.merge(tipo_contato);
        em.remove(tipo_contato);
        em.getTransaction().commit();
        em.close();
    }
    
    public List<Tipo_Contato> pesquisar(Tipo_Contato tipo_contato) {
        EntityManager em = Conexao.getEntityManager();
        StringBuilder sql = new StringBuilder("from Tipo_Contato t_c "
                + "where 1 = 1 ");
        if (tipo_contato.getId() !=null) {
            sql.append("and t_c.id = :idtipo_contato ");
        }
        if (tipo_contato.getTipo() !=null &&
                !tipo_contato.getTipo().equals("")){
            sql.append("and t_c.tipo like :tipo");
            
        }
        Query query = em.createQuery(sql.toString());
        if (tipo_contato.getId() !=null) {
            query.setParameter("idtipo_contato",tipo_contato.getId());
            
        }
        if (tipo_contato.getTipo() != null &&
                !tipo_contato.getTipo().equals("")){
            query.setParameter("tipo","%"+tipo_contato.getTipo());
        }
        return query.getResultList();
    }
}
