
package org.fa7.database.model;


import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa implements Serializable {

    private static final long serialVersionUID = -5673145906024695823L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Integer id;

    @Basic(optional = true)
    @Column(name = "email")
    protected String email;

    @Basic(optional = true)
    @Column(name = "telefone")
    protected  String telefone;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_registro")
    @Basic(optional = false)
    protected Date dataRegistro;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_alteracao")
    @Basic(optional = true)
    protected Date dataAlteracao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}