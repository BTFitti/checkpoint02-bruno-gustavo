package br.com.fiap.dao.impl;

import br.com.fiap.entity.Carro;

public class CarroDAOImpl extends HibernateGenericDAO<Carro, Long> {

	private static CarroDAOImpl  instance = null;
	
	public static CarroDAOImpl  getInstance() {
		if (instance == null) {
			instance = new CarroDAOImpl ();
		}
		
		return instance;
	}
	
	private CarroDAOImpl () {
		super(Carro.class);
	}

}
