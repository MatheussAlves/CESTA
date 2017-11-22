/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.df.sutic.cesta.enums;

/**
 *
 * @author matheus.dosantos
 */
public enum Turno {
    MATUTINO("Matutino"),VESPERTINO("Vespertino"),NOTURNO("Noturno");
    
    
    private String nome;
    
    private Turno(String nome){
        setNome(nome);
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
