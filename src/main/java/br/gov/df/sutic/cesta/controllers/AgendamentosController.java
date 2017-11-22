/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.df.sutic.cesta.controllers;

import br.gov.df.sutic.cesta.entities.Agendamento;
import br.gov.df.sutic.cesta.entities.Usuario;
import br.gov.df.sutic.cesta.enums.Turno;
import br.gov.df.sutic.cesta.persistence.AgendamentosFacade;
import br.gov.df.sutic.cesta.web.JSF;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author matheus.dosantos
 */
@Named
@ViewScoped
public class AgendamentosController implements Serializable{
    private Usuario usuario;
    private Integer usuarioId;
    private Agendamento agendamento;
    private Turno turno;
    private List<Agendamento> agendamentos;
    
    
    
    
    @Inject
    private AgendamentosFacade facade;
    
    public AgendamentosController(){
        setAgendamento(new Agendamento());
        setUsuario(new Usuario());
    }
    
    public void gravar(){
        System.out.println("Gravando agendamento...");
        facade.create(agendamento);
        setAgendamento(new Agendamento());
    }
    
    public void listaByTurno(){
        System.out.println("procurando...");
        setAgendamentos(facade.findBy(turno));
        
    }
    
    
    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }
    
    
    
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public AgendamentosFacade getFacade() {
        return facade;
    }
    
    
    
     public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }
    
      public boolean verificaUsuario(Usuario usuario){
       boolean verifica = !facade.podeExcluir(usuario);
       return verifica;
    }
    public List<Agendamento> getTodosAgendamentos(){
        return facade.findAll();
    }
}
