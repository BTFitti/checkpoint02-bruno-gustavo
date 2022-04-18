package br.com.fiap.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_carro")
@SequenceGenerator(name = "carro", sequenceName = "SQ_TB_CARRO", allocationSize = 1)

public class Carro implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public Carro(String placa, String cor, String chassi, Modelo modelo) {
		this.placa = placa;
		this.cor = cor;
		this.chassi = chassi;
		this.modelo = modelo;
	}
	
	
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carro")
	private Long id;
	
	@Column(name = "nr_placa", length = 7, nullable = false)
	private String placa;
	
	@Column(name = "ds_cor", length = 15, nullable = false, unique = true)
	private String cor;
	
	@Column(name = "nr_chassi", length = 17, nullable = false, unique = true)
	private String chassi;
	
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	
	@ManyToOne
	@JoinColumn(name="modelo_id")
	private Modelo modelo;
	
	@ManyToMany
	@JoinTable(name = "tb_acessorio_carro", joinColumns = @JoinColumn(name = "carro_id"), inverseJoinColumns = @JoinColumn(name = "acessorio_id"))
	
	private List<Acessorio> acessorios;
	
	public Long getId() {
		return id;
	}
	

	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "\nPlaca: " + this.getPlaca()
			 + "\nCor: " +   this.getCor()
		     + "\nChassi: " + this.getChassi();
	}
	

}
