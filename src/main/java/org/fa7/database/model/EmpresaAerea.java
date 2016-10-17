package org.fa7.database.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "empresa_aerea")
public class EmpresaAerea implements Serializable {

    private static final long serialVersionUID = 5262427790467856178L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Integer id;

    @Column(name = "nome")
    @Basic(optional = false)
    private String nome;

    @Column(name = "sigla")
    @Basic(optional = false)
    private String sigla;

    @OneToMany(mappedBy = "empresaAerea", targetEntity = Voo.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Voo> voos;

    public EmpresaAerea() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
