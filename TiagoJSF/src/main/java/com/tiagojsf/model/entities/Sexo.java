 
package com.tiagojsf.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author Tiago
 */
@Entity(name = "sexo")
public class Sexo implements Serializable {
    
    private static final long serialVersionUID = 1L;

    public Sexo() {
    }
      
    @Id
    @GeneratedValue
    @Column(name = "id_sexo", nullable = false)
    private Integer idSexo;
    
    @Column(unique = true, nullable = false, length = 9)
    private String Destricao;
    
    @OneToMany(mappedBy = "sexo", fetch = FetchType.LAZY)
    @ForeignKey(name="pessoa")
    private List<Pessoa> pessoas;
    
    public Integer getIdSexo() {
        return idSexo;
    }

    public void setIdSexo(Integer idSexo) {
        this.idSexo = idSexo;
    }

    public String getDestricao() {
        return Destricao;
    }

    public void setDestricao(String Destricao) {
        this.Destricao = Destricao;
    }

    public List<Pessoa> getPessoa() {
        return pessoas;
    }

    public void setPessoa(List<Pessoa> pessoa) {
        this.pessoas = pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.idSexo != null ? this.idSexo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sexo other = (Sexo) obj;
        if (this.idSexo != other.idSexo && (this.idSexo == null || !this.idSexo.equals(other.idSexo))) {
            return false;
        }
        return true;
    } 
    
}
