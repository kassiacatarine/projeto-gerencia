/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.web;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author alexandrelerario
 */
@Named(value = "jsfCidade")
@SessionScoped
public class JsfCidade implements Serializable {

    /**
     * Creates a new instance of JsfCidade
     */
    public JsfCidade() {
    }

    private int codigo;
    private String nome;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void persist() {
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage ms;
        br.data.entity.Cidade cid = new br.data.entity.Cidade();
        cid.setCodigo(codigo);
        cid.setNome(nome);
        if(cid.getCodigo() > 0){
            new br.data.crud.CrudCidade().persist(cid);
            context.addMessage(null, new FacesMessage("Registro inserido com sucesso!"));
        } else{
            context.addMessage(null, new FacesMessage("Codigo invalido."));
        }
    }

    public java.util.Collection<br.data.entity.Cidade> getAll() {
        return new br.data.crud.CrudCidade().getAll();
    }
}
