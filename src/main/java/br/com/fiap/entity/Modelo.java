package br.com.fiap.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "tb_modelo")
@SequenceGenerator(name = "modelo", sequenceName = "SQ_TB_MODELO", allocationSize = 1)


public class Modelo implements Serializable {

	private static final long serialVersionUID = -6348016465976045271L;

	public Modelo(String descricao) {
		this.descricao = descricao;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modelo")
	private Long id;
	
	@Column(name = "ds_descricao", length = 100, nullable = false)
	private String descricao;
	
	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@OneToMany(mappedBy = "modelo")
	private Set<Carro> carros;

	@Override
	public String toString() {
		return "\nDescricao: " + this.getDescricao();

	}

}