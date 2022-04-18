package br.com.fiap.service.impl;

import java.util.List;

import br.com.fiap.entity.Acessorio;
import br.com.fiap.service.impl.AcessorioServiceImpl;
import br.com.fiap.dao.impl.AcessorioDAOImpl;
import br.com.fiap.dao.impl.CarroDAOImpl;
import br.com.fiap.service.impl.AcessorioServiceImpl;
import br.com.fiap.service.GenericService;

public class AcessorioServiceImpl extends GenericService<Acessorio, Long> {

	private static AcessorioServiceImpl instance = null;
	private AcessorioDAOImpl acessorioDAO;
	private CarroDAOImpl carroDAO;
	
	private AcessorioServiceImpl() {
		acessorioDAO = AcessorioDAOImpl.getInstance();
		carroDAO =  CarroDAOImpl.getInstance();
	}
	
	public static AcessorioServiceImpl getInstance() {
		if (instance == null) {
			instance = new AcessorioServiceImpl();
		}
		return instance;
	}
	
	
	@Override
	public void cadastrar(Acessorio instance) {
		try {
			acessorioDAO.salvar(instance, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public void atualizar(Acessorio instance) {
		try {
			acessorioDAO.atualizar(instance, getEntityManager());
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
			acessorioDAO.remover(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public Acessorio obter(Long id) {
		Acessorio acessorio = null;
		try {
			acessorio = acessorioDAO.obterPorId(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		return acessorio;
	}

	@Override
	public List<Acessorio> listar() {
		List<Acessorio> acessorios = null;
		try {
			acessorios = acessorioDAO.listar(getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		return acessorios;
	}

	
}
