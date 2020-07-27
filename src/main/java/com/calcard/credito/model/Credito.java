package com.calcard.credito.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Credito {

    public Credito() {}

    public Credito(Cliente cliente, double limiteMaximo, double limiteMinimo, String motivo, boolean aprovado) {
        this.cliente = cliente;
        this.limiteMaximo = limiteMaximo;
        this.limiteMinimo = limiteMinimo;
        this.motivo = motivo;
        this.aprovado = aprovado;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Cliente cliente;
    private Boolean aprovado;
    private double limiteMinimo;
    private double limiteMaximo;
    private String motivo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Boolean getAprovado() {
        return aprovado;
    }

    public void setAprovado(Boolean aprovado) {
        this.aprovado = aprovado;
    }

    public double getLimiteMinimo() {
        return limiteMinimo;
    }

    public void setLimiteMinimo(double limiteMinimo) {
        this.limiteMinimo = limiteMinimo;
    }

    public double getLimiteMaximo() {
        return limiteMaximo;
    }

    public void setLimiteMaximo(double limiteMaximo) {
        this.limiteMaximo = limiteMaximo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
