package br.com.fiap.service.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.entity.Acessorio;
import br.com.fiap.entity.Carro;
import br.com.fiap.dao.impl.AcessorioDAOImpl;
import br.com.fiap.dao.impl.CarroDAOImpl;
import br.com.fiap.dao.impl.ModeloDAOImpl;
import br.com.fiap.service.GenericService;

public class CarroServiceImpl extends GenericService<Carro, Long> {

	private static CarroServiceImpl instance = null;
	private CarroDAOImpl carroDAO;
	private AcessorioDAOImpl acessorioDAO;
	private ModeloDAOImpl modeloDAO;

	private CarroServiceImpl() {
		carroDAO = CarroDAOImpl.getInstance();
		acessorioDAO = AcessorioDAOImpl.getInstance();
		modeloDAO = ModeloDAOImpl.getInstance();
	}

	public static CarroServiceImpl getInstance() {
		if (instance == null) {
			instance = new CarroServiceImpl();
		}
		return instance;
	}

	public void vincular(Long idCarro, Long idAcessorio) {
		try {
			Carro carro = obter(idCarro);
			Acessorio acessorio = acessorioDAO.obterPorId(idAcessorio, getEntityManager());
			List<Acessorio> acessorios = carro.getAcessorios();
			Boolean vinculado = false;
			if (acessorios == null) {
				acessorios = new ArrayList<Acessorio>();
			} else {
				for (Acessorio acessorioDB : acessorios) {
					if (acessorioDB.getId().equals(idAcessorio)) {
						vinculado = true;
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public void cadastrar(Carro instance) {
		try {
			carroDAO.salvar(instance, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public void atualizar(Carro instance) {
		try {
			carroDAO.atualizar(instance, getEntityManager());
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
			carroDAO.remover(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public Carro obter(Long id) {
		Carro carro = null;
		try {
			carro = carroDAO.obterPorId(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		return carro;
	}

	@Override
	public List<Carro> listar() {
		List<Carro> carros = null;
		try {
			carros = carroDAO.listar(getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		return carros;
	}

}
