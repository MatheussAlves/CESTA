/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.df.sutic.cesta.controllers;

import br.gov.df.sutic.cesta.enums.Sexo;
import br.gov.df.sutic.cesta.enums.Turno;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author matheus.dosantos
 */
@Named
@ViewScoped
public class EnumController implements Serializable{
    private Sexo sexos;
    private Turno turnos;

 
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Turno[] getTurnos() {
        return Turno.values();
    }

    public void setTurnos(Turno turnos) {
        this.turnos = turnos;
    }

    
    public Sexo[] getSexos(){
        return Sexo.values();
    }
    
    
   

    public void setSexos(Sexo sexos) {
        this.sexos = sexos;
    }
    
    
    
    //</editor-fold>
    
    
}
