/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.df.sutic.cesta.persistence;

import br.gov.df.sutic.cesta.entities.Agendamento;
import br.gov.df.sutic.cesta.entities.Agendamento_;
import br.gov.df.sutic.cesta.entities.Usuario;
import br.gov.df.sutic.cesta.enums.Turno;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author matheus.dosantos
 */
@Stateless
public class AgendamentosFacade extends AbstractFacade<Agendamento>{
    
    @PersistenceContext
    private EntityManager em;
    
    
    public AgendamentosFacade(){
        super(Agendamento.class);
    }

    public EntityManager getEm() {
        return em;
    }

    @Override
    protected EntityManager getEntityManager() {
        return getEm();
    }
    
     public List<Agendamento> findBy(Turno turno){
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root root = cq.from(getEntityClass());
        
        cq.select(root).where(cb.equal(root.get(Agendamento_.turno), turno));
        
        return getEntityManager().createQuery(cq).getResultList();
    }
      public boolean podeExcluir(Usuario usuario){
          boolean verificador = !exists(usuario, Agendamento_.usuario);
        /*CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root root = cq.from(getEntityClass());
        
        cq.select(root).where(cb.equal(root.get(Agendamento_.usuario), usuario));
        boolean verificador = !getEntityManager().createQuery(cq).getResultList().isEmpty();
        */
        return verificador;
    }
  

   
    
    
   
}
