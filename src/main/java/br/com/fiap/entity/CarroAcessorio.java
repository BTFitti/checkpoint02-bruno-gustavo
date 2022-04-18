package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_acessorio_carro")
public class CarroAcessorio implements Serializable {

	private static final long serialVersionUID = -7221609995023927154L;

    public CarroAcessorio(Carro carro, Acessorio acessorio) {
        this.carro = carro;
        this.acessorio = acessorio;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acessorio")
    private Long id;

   
    @ManyToOne
    @JoinColumn(name = "carro_id")
    private Carro carro;

    @ManyToOne
    @JoinColumn(name = "acessorio_id")
    private Acessorio acessorio;

    public Long getId() {
        return id;
    }


    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Acessorio getAcessorio() {
        return acessorio;
    }

    public void setAcessorio(Acessorio acessorio) {
        this.acessorio = acessorio;
    }

    @Override
    public String toString() {
        return "Carro: " + this.getCarro().getPlaca() + " | Acessório: " + this.getAcessorio().getDescricao();
    }
}