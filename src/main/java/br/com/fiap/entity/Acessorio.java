package br.com.fiap.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_acessorio")
@SequenceGenerator(name = "acessorio", sequenceName = "SQ_TB_ACESSORIO", allocationSize = 1)

public class Acessorio implements Serializable {
	private static final long serialVersionUID = 1L;


	public Acessorio(String descricao) {
		this.descricao = descricao;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acessorio")
	private Long id;

	@Column(name = "ds_descricao", length = 100, nullable = false)
	private String descricao;
	
	@ManyToMany(mappedBy="acessorios")
	private List<Carro> carros;
	
	public List<Carro> getCarros() {
		return carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

	@Override
	public String toString() {
		return "\nDescricao: " + this.getDescricao();

	}

}
