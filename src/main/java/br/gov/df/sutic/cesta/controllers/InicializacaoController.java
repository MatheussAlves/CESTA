/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.df.sutic.cesta.controllers;

import br.gov.df.sutic.cesta.entities.Agendamento;
import br.gov.df.sutic.cesta.entities.Usuario;
import br.gov.df.sutic.cesta.enums.Sexo;
import br.gov.df.sutic.cesta.enums.Turno;
import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.ejb.Singleton;

/**
 *
 * @author matheus.dosantos
 */
@Singleton
@Startup
public class InicializacaoController {
    
    private Agendamento agendamento;
    
    public InicializacaoController(){
        adicionarAgendamentos();
        
    }
    
    
    

    public Agendamento getAgendamento() {
        return agendamento;
    }
    
    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }
    @PostConstruct
    public void adicionarAgendamentos(){
        System.out.println("Carregando agendamentos...");
        Agendamento a1 = new Agendamento();
        a1.setMotivo("Motivo de teste");
        a1.setTurno(Turno.NOTURNO);
        a1.setUsuario(adicionarUsuarios("Matheus agendamento 1"));
        
        Agendamento a2 = new Agendamento();
        a2.setMotivo("Motivo de testes agendamento 2");
        a2.setTurno(Turno.MATUTINO);
        a2.setUsuario(adicionarUsuarios("Jose teste 2"));
        
        Agendamento a3 = new Agendamento();
        a3.setMotivo("Motivo de testes agendamento 3");
        a3.setTurno(Turno.NOTURNO);
        a3.setUsuario(adicionarUsuarios("Joao teste 3"));
        
        
    }
    public Usuario adicionarUsuarios(String nome){
        Usuario user1 = new Usuario();
        user1.setNome(nome);
        user1.setCpf("123123131");
        user1.setSenha("12312312");
        user1.setTelefone("902348248290");
        user1.setAtivo(true);
        user1.setSexo(Sexo.MASCULINO);
        return user1;
        
    }
}
