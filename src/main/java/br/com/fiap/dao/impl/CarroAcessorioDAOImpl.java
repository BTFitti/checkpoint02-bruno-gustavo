package br.com.fiap.dao.impl;

import br.com.fiap.entity.CarroAcessorio;

public class CarroAcessorioDAOImpl extends HibernateGenericDAO<CarroAcessorio, Long>{

    private static CarroAcessorioDAOImpl instance = null;

    public CarroAcessorioDAOImpl() {
        super(CarroAcessorio.class);
    }

    public static CarroAcessorioDAOImpl getInstance() {

        if (instance == null) {
            instance = new CarroAcessorioDAOImpl();
        }

        return instance;
    }
}