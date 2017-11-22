package br.gov.df.sutic.cesta.controllers;

import br.gov.df.sutic.cesta.entities.Usuario;
import br.gov.df.sutic.cesta.persistence.UsuarioFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Controlando usuários desde 2017.
 * @author Bruno Santos
 */
@Named
@ViewScoped
public class UsuarioController implements Serializable
{
    private Usuario usuario;
    private List<Usuario> usuarios;
    private List<Map<String,String>> apelidos;
    //private Map<String, String> apelidos;
    private String apelido;
    
    
    
    @Inject
    private UsuarioFacade facade;
    
    public UsuarioController(){
        
        setUsuario(new Usuario());
        setApelidos(new ArrayList<>());
        adicionarApelido(0);
    }
    
    public void gravar(){
      
        System.out.println("Gravando usuario...");
        
        
         for (Map<String, String> apelido1 : getApelidos()) {
        //getUsuario().getApelidos().add(apelido1.get("nome"));
         getUsuario().adicionarApelido(apelido1.get("nome"));       
        }
        facade.create(usuario);
        setUsuario(new Usuario());
        //System.out.println(this.usuario.getNome());
        //getUsuario().setApelidos(getApelidos().stream().map(x -> x.get("nome")).collect(Collectors.toSet())); 
        //getUsuario().setApelidos(getApelidos());
       
    }
    public String editar(){
        
        for (Map<String, String> apelido1 : getApelidos()) {
        //getUsuario().getApelidos().add(apelido1.get("nome"));
         getUsuario().adicionarApelido(apelido1.get("nome"));
        }
            System.out.println("Editando...");
            facade.edit(usuario);
            return "alterarUsuarios";
    }
    public void remover(Usuario usuario){
        System.out.println("Removendo usuario...");
        facade.remove(usuario);
        
    }
    public Usuario getUsuario() {
       
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioFacade getFacade() {
        return facade;
    }

    public List<Map<String, String>> getApelidos() {
        return apelidos;
    }

    public void setApelidos(List<Map<String, String>> apelidos) {
        this.apelidos = apelidos;
    }

    

    
    
    public void adicionarApelido(int posicao){
        
        
        
       // getApelidos().put(posicao, new HashMap<>());
        getApelidos().add(posicao, new HashMap<>());
    }
    public void removerApelido(Map<String, String> apelido){
        getApelidos().remove(apelido);
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public List<Usuario> getUsuarios() {
      
        
        this.usuarios = facade.findAll();
       
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = facade.findAll();
    }

    
    
    public void prepararEdicao(){
        
      
        for (String apelido1 : getUsuario().getApelidos()) {    
            System.out.println("Preparou apelidos...");
            Map map = new HashMap();
            map.put("nome",apelido1);
            getApelidos().add(map);
            
        }
        getUsuario().setApelidos(new HashSet<>());
    }
    
    
    public boolean edicao(){
        return true;
    }
    
    
    
    
    
    
    
}