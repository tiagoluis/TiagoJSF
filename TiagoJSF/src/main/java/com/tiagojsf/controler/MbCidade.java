package com.tiagojsf.controler;

import com.tiagojsf.model.dao.HibernateDAO;
import com.tiagojsf.model.dao.InterfaceDAO;
import com.tiagojsf.model.entities.Cidade;
import com.tiagojsf.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "mbCidade")
@SessionScoped
public class MbCidade implements Serializable {

    private static final long serialVersionUID = 1L;

    private Cidade cidade = new Cidade();
    private List<Cidade> cidades;

    public MbCidade() {
    }

    private InterfaceDAO<Cidade> cidadeDAO() {
        InterfaceDAO<Cidade> cidadeDAO = new HibernateDAO<Cidade>(Cidade.class, FacesContextUtil.getRequestSession());
        return cidadeDAO;
    }

    public String editCidade() {
        return "/retrisct/cadastrarcidade.faces";
    }

    public String addCidade() {
        if (cidade.getIdCidade() == null || cidade.getIdCidade() == 0) {
            insertCidade();
        } else {
            updateCidade();
            limparCidade();
        }

        return null;
    }

    public void insertCidade() {
        cidadeDAO().save(cidade);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Inclusão realizada com Sucesso", ""));
    }

    public void updateCidade() {
        cidadeDAO().update(cidade);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização  realizado com Sucesso", ""));
    }

    public void deleteCidade() {
        cidadeDAO().remove(cidade);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização  realizado com Sucesso", ""));
    }

    private String limparCidade() {
        cidade = new Cidade();
        return "/restrict/cadastrarcidade.faces";
    }
 
    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    public List<Cidade> getCidades() {
        cidades = cidadeDAO().getEntities();
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    
    
}
