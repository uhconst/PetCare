/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.domain.Pessoa;

/**
 *
 * @author Constancio
 */
public class PessoaDao{
    
    public void salvarAtualizar(Pessoa pessoa) {
        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();
        if(pessoa.getId() !=null){
            pessoa = em.merge(pessoa);
        }
        em.persist(pessoa);
        em.getTransaction().commit();
        em.close();
    }
    
    public void excluir(Pessoa pessoa) {
        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();
        pessoa = em.merge(pessoa);
        em.remove(pessoa);
        em.getTransaction().commit();
        em.close();
    }
    
    public List<Pessoa> pesquisar(Pessoa pessoa) {
        EntityManager em = Conexao.getEntityManager();
        StringBuilder sql = new StringBuilder("from Pessoa c "
                + "where 1 = 1 ");
        if (pessoa.getId() !=null) {
            sql.append("and c.id = :id_pessoa ");
        }
        if (pessoa.getNome() !=null &&
                !pessoa.getNome().equals("")){
            sql.append("and c.nome like :nome");
            
        }
        Query query = em.createQuery(sql.toString());
        if (pessoa.getId() !=null) {
            query.setParameter("id_pessoa",pessoa.getId());
            
        }
        if (pessoa.getNome() != null &&
                !pessoa.getNome().equals("")){
            query.setParameter("nome","%"+pessoa.getNome());
        }
        return query.getResultList();
    }
    
}
