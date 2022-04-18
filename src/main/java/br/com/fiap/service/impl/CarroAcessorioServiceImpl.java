package br.com.fiap.service.impl;

import br.com.fiap.dao.impl.CarroAcessorioDAOImpl;
import br.com.fiap.dao.impl.AcessorioDAOImpl;
import br.com.fiap.entity.CarroAcessorio;
import br.com.fiap.service.GenericService;
import br.com.fiap.dao.*;

import java.util.List;

public class CarroAcessorioServiceImpl extends GenericService<CarroAcessorio, Long> {

    private static CarroAcessorioServiceImpl instance = null;

    private CarroAcessorioDAOImpl carroAcessorioDAO;

    private CarroAcessorioServiceImpl() {
        carroAcessorioDAO = CarroAcessorioDAOImpl.getInstance();
    }

    public static CarroAcessorioServiceImpl getInstance() {

        if (instance == null) {
            instance = new CarroAcessorioServiceImpl();
        }

        return instance;
    }

    @Override
    public void cadastrar(CarroAcessorio instance) {
        try {
            carroAcessorioDAO.salvar(instance, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }
    }

    @Override
    public void atualizar(CarroAcessorio instance) {
        try {
            carroAcessorioDAO.atualizar(instance, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }
    }

    @Override
    public void remover(Long id) {
        try {
        	 carroAcessorioDAO.remover(id, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }
    }

    @Override
    public CarroAcessorio obter(Long id) {
    	CarroAcessorio acessorioCarro = null;

        try {
            acessorioCarro = carroAcessorioDAO.obterPorId(id, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }

        return acessorioCarro;
    }

    @Override
    public List<CarroAcessorio> listar() {
        List<CarroAcessorio> acessorios = null;

        try {
            acessorios = carroAcessorioDAO.listar(getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }

        return acessorios;
    }
}