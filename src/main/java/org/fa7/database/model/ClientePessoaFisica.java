package org.fa7.database.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "cliente_pessoa_fisica")
@PrimaryKeyJoinColumn(name = "id_pessoa")
public class ClientePessoaFisica extends Pessoa {

    private static final long serialVersionUID = 6882115490287337078L;

    @Column(name = "nome")
    @Basic(optional = false)
    private String nome;

    @Column(name = "cpf")
    @Basic(optional = false)
    private String cpf;

    public ClientePessoaFisica() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}