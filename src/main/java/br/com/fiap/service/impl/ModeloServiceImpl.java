package br.com.fiap.service.impl;

import java.util.List;

import br.com.fiap.entity.Modelo;
import br.com.fiap.dao.impl.AcessorioDAOImpl;
import br.com.fiap.dao.impl.CarroDAOImpl;
import br.com.fiap.dao.impl.ModeloDAOImpl;
import br.com.fiap.service.GenericService;

public class ModeloServiceImpl extends GenericService<Modelo, Long> {

	private static ModeloServiceImpl instance = null;
	private ModeloDAOImpl modeloDAO;
	private CarroDAOImpl carroDAO;

	
	private ModeloServiceImpl() {
		carroDAO = CarroDAOImpl.getInstance();
		modeloDAO = ModeloDAOImpl.getInstance();
	}
	

	public static ModeloServiceImpl getInstance() {
		if (instance == null) {
			instance = new ModeloServiceImpl();
		}
		return instance;
	}
	
	@Override
	public void cadastrar(Modelo instance) {
		try {
			modeloDAO.salvar(instance, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public void atualizar(Modelo instance) {
		try {
			modeloDAO.atualizar(instance, getEntityManager());
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
			modeloDAO.remover(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public Modelo obter(Long id) {
		Modelo modelo = null;
		try {
			modelo = modeloDAO.obterPorId(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		return modelo;
	}

	@Override
	public List<Modelo> listar() {
		List<Modelo> modelos = null;
		try {
			modelos = modeloDAO.listar(getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		return modelos;
	}

}
