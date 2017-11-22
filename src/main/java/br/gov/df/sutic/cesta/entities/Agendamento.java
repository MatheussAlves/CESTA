/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */                                                        
package br.gov.df.sutic.cesta.entities;

import br.gov.df.sutic.cesta.enums.Turno;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

/**
 *
 * @author matheus.dosantos
 */
@Entity
public class Agendamento extends AbstractEntity{
    @ManyToOne
    private Usuario usuario;
    @Column(columnDefinition = "text")
    private String motivo;
    @Enumerated(EnumType.STRING)
    private Turno turno;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }
    
    
    
    
    
    
}
