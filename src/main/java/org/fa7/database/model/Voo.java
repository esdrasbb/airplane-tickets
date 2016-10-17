package org.fa7.database.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "voo")
public class Voo implements Serializable {

    private static final long serialVersionUID = 8975930420033386634L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Integer id;

    @Column(name = "sigla")
    @Basic(optional = false)
    private String sigla;

    @Column(name = "numero")
    @Basic(optional = false)
    private String numero;

    @Temporal(TemporalType.TIME)
    @Column(name = "horario_previsto_saida")
    @Basic(optional = false)
    private Date horarioPrevistoSaida;

    @Temporal(TemporalType.TIME)
    @Column(name = "horario_previsto_chegada")
    @Basic(optional = false)
    private Date horarioPrevistoChegada;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_aeroporto_saida", nullable = false)
    private Aeroporto aeroportoSaida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_aeroporto_chegada", nullable = false)
    private Aeroporto aeroportoChegada;

    @Column(name = "valor", precision = 10, scale = 2)
    @Basic(optional = false)
    private Double valor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa_aerea", nullable = false)
    private EmpresaAerea empresaAerea;

    //FIXME adicionar assentos?
    //FIXME data voo?


    public Voo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getHorarioPrevistoSaida() {
        return horarioPrevistoSaida;
    }

    public void setHorarioPrevistoSaida(Date horarioPrevistoSaida) {
        this.horarioPrevistoSaida = horarioPrevistoSaida;
    }

    public Date getHorarioPrevistoChegada() {
        return horarioPrevistoChegada;
    }

    public void setHorarioPrevistoChegada(Date horarioPrevistoChegada) {
        this.horarioPrevistoChegada = horarioPrevistoChegada;
    }

    public Aeroporto getAeroportoSaida() {
        return aeroportoSaida;
    }

    public void setAeroportoSaida(Aeroporto aeroportoSaida) {
        this.aeroportoSaida = aeroportoSaida;
    }

    public Aeroporto getAeroportoChegada() {
        return aeroportoChegada;
    }

    public void setAeroportoChegada(Aeroporto aeroportoChegada) {
        this.aeroportoChegada = aeroportoChegada;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public EmpresaAerea getEmpresaAerea() {
        return empresaAerea;
    }

    public void setEmpresaAerea(EmpresaAerea empresaAerea) {
        this.empresaAerea = empresaAerea;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
