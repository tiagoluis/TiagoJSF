/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tiagojsf.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Tiago
 */
@Entity(name = "endereco")
public class Endereco implements Serializable{ 
    private static final long serialVersionUID = 1L;
    
    
    
    @Id
    @GeneratedValue
    @Column(name="id_endereco", nullable = false)
    private Integer idEndereco;
    
    @Column(name = "bairro", length = 80)
    private String bairro;
    
    
    @Column(name = "nm_log", length = 80)
    private String nomeLogradouro;
    
    @Column(name = "cep", length = 80)
    private String cep;
    
    @Column(name = "numero", length = 80)
    private Integer numero;
    
    @Column(name = "complemento", length = 80)
    private String complemento;
    
     
    
    
    
}
